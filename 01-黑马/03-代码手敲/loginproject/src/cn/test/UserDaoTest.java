package cn.test;

import cn.dao.UserDao;
import cn.domain.User;
import org.junit.Test;

/**
 * @Author liming
 * @Date 2022/4/27 8:14
 **/
public class UserDaoTest {
    @Test
    public void testLogin(){
        User loginUser = new User();

        loginUser.setUsername("superbaby");
        loginUser.setPassword("123456");

        UserDao dao = new UserDao();
        User user = dao.login(loginUser);

//        System.out.println(loginUser);
        System.out.println(user);
    }
}
