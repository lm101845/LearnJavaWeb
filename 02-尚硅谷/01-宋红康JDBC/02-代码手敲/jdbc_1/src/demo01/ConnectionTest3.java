package demo01;

import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author liming
 * @Date 2022/4/5 12:08
 **/
public class ConnectionTest3 {
    //连接方式三：使用DriverManager(不是接口是类)替换Driver(不用驱动直接进行操作了)
    @Test
    public void testConnection3() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        //1.获取Driver的实现类对象
        Class  clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();
        //2.提供另外3个连接的基本信息
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8";
        String user = "root";
        String password = "123456";
        //3.注册驱动
        DriverManager.registerDriver(driver);
        //4.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }
}
