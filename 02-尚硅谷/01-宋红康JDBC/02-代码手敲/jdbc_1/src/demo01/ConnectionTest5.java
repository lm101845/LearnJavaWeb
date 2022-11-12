package demo01;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author liming
 * @Date 2022/4/5 12:08
 **/
public class ConnectionTest5 {
    //连接方式五(最终版)：将数据库连接需要的4个基本信息声明在配置文件中，通过读取配置文件的方式获取连接
    /**
     * 此种方法好处？
     *  1.实现了数据与代码的分离，实现了解耦(不用硬编码了)
     *  2. 如果需要修改配置文件信息，可以避免程序重新打包
     * */
    @Test
    public void testConnection5() throws SQLException, ClassNotFoundException, IOException {
        //1.读取配置文件中的4个配置信息
        //通过类的加载器来加载
//        InputStream is = ConnectionTest5.class.getClassLoader().getResourceAsStream("jdbc.properties");
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        //ClassLoader负责在运行时将Java类动态加载到JVM中，而且ClassLoader是JRE的一部分。
        // 因此，由于ClassLoader的存在，JVM无需了解底层文件和文件系统即可运行Java程序。
        //这种方式也可以获得一个系统类加载器

        Properties props = new Properties();
        //Properties（Java.util.Properties）是Java中一个比较重要的类，主要用于读取Java的配置文件
        props.load(is);

        String user = props.getProperty("user");
        String password = props.getProperty("password");
        String url = props.getProperty("url");
        String driverClass = props.getProperty("driverClass");


        //2.加载驱动
        Class.forName(driverClass);

        //3.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }
}
