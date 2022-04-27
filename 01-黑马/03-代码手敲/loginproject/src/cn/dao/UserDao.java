package cn.dao;

/**
 * @Author liming
 * @Date 2022/4/23 17:37
 **/

import cn.domain.User;
import cn.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * �������ݿ���User�����
 * */
public class UserDao {
    //����JDBCTemplate������
    //����JDBCTemplate������
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * @param loginUser ֻ���û���������
     * @return user�����û�ȫ������,���û�в�ѯ��������null
     */
    public User login(User loginUser){
        try {
            //1.��дsql
            String sql = "select * from user where username = ? and password = ?";
            //����query����
            User user = template.queryForObject(
                    sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword()
            );
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();   //��¼��־
            return null;
        }
    }
}
