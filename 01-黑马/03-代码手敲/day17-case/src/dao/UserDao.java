package dao;

/**
 * @Author liming
 * @Date 2022/5/13 13:02
 **/

import domain.User;

import java.sql.SQLException;
import java.util.List;

/**
 * 用户操作的DAO
 * */
public interface UserDao {
    public List<User> findAll() throws SQLException;
}
