package util;

/**
 * @Author liming
 * @Date 2022/4/9 13:59
 **/

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @Description:操作数据库的工具类
 * @Param:
 * @return:
 */
public class JDBCUtils {
    /** 
    * @Description: 获取数据库的连接
    * @Param: []
    * @return: java.sql.Connection
    */
    public static Connection getConnection() throws Exception{
        //1.读取配置文件中的4个配置信息
        //通过类的加载器来加载
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        //这种方式也可以获得一个系统类加载器

        Properties props = new Properties();
        props.load(is);

        String user = props.getProperty("user");
        String password = props.getProperty("password");
        String url = props.getProperty("url");
        String driverClass = props.getProperty("driverClass");


        //2.加载驱动
        Class.forName(driverClass);

        //3.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    /**
    * @Description:关闭连接和Statement的操作
    * @Param: []
    * @return: void
    */
    public static void closeResource(Connection conn, Statement ps){
        try {
            if(ps != null){
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
