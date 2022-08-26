package demo03;

import demo01.ConnectionTest5;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

/**
 * @Author liming
 * @Date 2022/4/9 12:03
 **/
/*
 * 使用PreparedStatement来替换Statement,实现对数据表的增删改操作
 *
 * 增删改；查
 *
 *
 */
public class PreparedStatementUpdateTest {
    //向customers表中添加一条记录
    @Test
    //涉及到资源关闭，不要用throws，用try...catch
    public void testInsert() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1.读取配置文件中的4个配置信息
            //通过类的加载器来加载
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

            Properties props = new Properties();
            props.load(is);

            String user = props.getProperty("user");
            String password = props.getProperty("password");
            String url = props.getProperty("url");
            String driverClass = props.getProperty("driverClass");


            //2.加载驱动
            Class.forName(driverClass);

            //3.获取连接
            conn = DriverManager.getConnection(url, user, password);
            System.out.println(conn);

            //4.预编译SQL语句，返回PreparedStatement实例
            String sql = "insert into customers(name,email,birth)values(?,?,?)";//?:占位符
            //这里的?是占位符
            //正因为它写的是占位符，所以它才解决了statement的弊端，可以防止SQL注入
            ps = conn.prepareStatement(sql);

            //5.填充占位符(java和数据库交互，索引从1开始)
            ps.setString(1, "nezha111");
            ps.setString(2, "nezha111@gmail.com");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse("1000-01-01");
            ps.setDate(3, new Date(date.getTime()));

            //6.执行操作
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //7.资源关闭
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
}
