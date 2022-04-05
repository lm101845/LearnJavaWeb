package demo01;

import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author liming
 * @Date 2022/4/5 12:08
 **/
public class ConnectionTest4 {
    //连接方式四：在三基础上的优化——只是加载驱动，不用显式注册驱动了
    @Test
    public void testConnection4() throws SQLException, ClassNotFoundException {
        //1.提供3个连接的基本信息
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8";
        String user = "root";
        String password = "123456";

        //2.获取Driver的实现类对象——这个也是可以省略的！！！！mysql也帮你做了！！！！
        //但是这步不要省略，因为mysql帮你省略了，但是oracle没有帮你省略，从通用角度说，不要省
        Class.forName("com.mysql.cj.jdbc.Driver");

        //驱动不用写了，它(mysql)帮我们做了
        //3.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }
}
