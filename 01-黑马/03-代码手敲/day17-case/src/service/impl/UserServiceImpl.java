package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import service.UserService;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author liming
 * @Date 2022/5/13 12:59
 **/
public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();
    @Override
    public List<User> findAll() throws SQLException {
        //调用DAO来完成查询

        return dao.findAll();
    }
}
