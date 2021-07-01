package util;

/**
 * @author 李明
 * @date 2021年06月23日 17:19
 */

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC工具类
 */
public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    //为什么是静态的呢？因为这里只有静态变量才能被静态代码块所访问

    /**
     * 文件的读取，只需要读取一次即可拿到这些值——使用静态代码块
     * 静态代码块会随着类的加载而加载，并且只会执行一次
     */
    static{
        //读取资源文件，获取值
        //可以使用很多种方式把properties配置文件读到内存当中
        try {
            //1.Properties集合类
            Properties pro = new Properties();

            //获取src路径下的文件的方式---->ClassLoader类加载器
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL res = classLoader.getResource("jdbc.properties");
            String path = res.getPath();
            //System.out.println(path);

            //2.加载文件
            //pro.load(new FileReader("src/jdbc.properties"));
            pro.load(new FileReader(path));
            //在静态代码块中只能处理异常，不能抛，因为抛要借助方法

            //3.获取数据，赋值
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            //4.注册驱动
            Class.forName("driver");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取连接
     * @return java.sql.Connection
    */
//    public static Connection getConnetcion(String url,String user,String password) throws SQLException{
//        //将来要返回一个Connection对象
//        //这里的字符串不能够写死，否则会不通用
//        //return DriverManager.getConnection("jdbc:mysql:///db4","root","123456");
//
//        //return DriverManager.getConnection(url,user,password);
//        //可以通过传参的方式，但是这样也不是很好——传递参数很麻烦
//
//    }

//    public static Connection getConnetcion(String url,String user,String password) throws SQLException{
//        //我既不想传参，还想实现一种动态的效果(保证工具类的通用性)
//        //解决方案：定义一个配置文件，里面记录参数
//        //将来参数发生变化的时候，我们改配置文件即可
//        return DriverManager.getConnection(url, user, password);
//    }

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url, user, password);
    }

    /**
     * 释放资源
     * @param stmt
     * @param conn 
    */
    public static void close(Statement stmt,Connection conn){
        //你要释放哪个资源，你得告诉我
        //执行增删改的时候，要释放stmt和conn对象
        //执行查询语句的时候，要释放rs,stmt和conn对象
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rs,Statement stmt, Connection conn){
        //这个是方法的重载
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


}
