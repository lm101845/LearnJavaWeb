package jdbctemplate;

/**
 * @author ����
 * @date 2021��07��01�� 23:52
 */

import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

/**
 * JdbcTemplate����
 */
public class JDBCTemplateDemo01 {
    public static void main(String[] args) {
        //1.����jar��
        //2.����JDBCTemplate����
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

        //3.���÷���
        String sql = "update account set balance = 5000 where id = ?";
        int count = template.update(sql, 4);
        System.out.println(count);
    }
}
