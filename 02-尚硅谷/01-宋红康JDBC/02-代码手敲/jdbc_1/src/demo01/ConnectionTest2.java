package demo01;

import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author liming
 * @Date 2022/4/5 12:08
 **/
public class ConnectionTest2 {
    //连接方式二：对方式一的迭代：在如下的程序中不出现第三方的api,使得程序具有更好的移植性
    @Test
    public void testConnection2() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
      //1.获取Driver的实现类对象，这里我们使用反射
        Class  clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();
        //JAVA9之后不推荐使用newInstance()方法

        //2.提供要连接的数据库
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8";
        Properties info = new Properties();
        //3.提供连接需要的用户名和密码
        info.setProperty("user","root");
        info.setProperty("password","123456");
        //4.获取连接
        Connection conn = driver.connect(url, info);
        System.out.println(conn);
    }
}
