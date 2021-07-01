package jdbctemplate;

/**
 * @author 李明
 * @date 2021年07月01日 23:52
 */

import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

/**
 * JdbcTemplate入门
 */
public class JDBCTemplateDemo01 {
    public static void main(String[] args) {
        //1.导入jar包
        //2.创建JDBCTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

        //3.调用方法
        String sql = "update account set balance = 5000 where id = ?";
        int count = template.update(sql, 4);
        System.out.println(count);
    }
}
