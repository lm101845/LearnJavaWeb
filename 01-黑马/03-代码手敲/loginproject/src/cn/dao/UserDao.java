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
 * 操作数据库中User表的类
 * */
public class UserDao {
    //声明JDBCTemplate对象共用
    //声明JDBCTemplate对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * @param loginUser 只有用户名和密码
     * @return user包含用户全部数据,如果没有查询到，返回null
     */
    public User login(User loginUser){
        try {
            //1.编写sql
            String sql = "select * from user where username = ? and password = ?";
            //调用query方法
            User user = template.queryForObject(
                    sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword()
            );
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();   //记录日志
            return null;
        }
    }
}
