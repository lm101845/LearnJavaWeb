package service;

/**
 * @Author liming
 * @Date 2022/5/13 12:19
 **/

import domain.User;

import java.sql.SQLException;
import java.util.List;

/**
 * 用户管理的业务接口
 * */
public interface UserService {
    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> findAll() throws SQLException;
}
