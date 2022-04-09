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
public class ConnectionTest {
    //连接方式一
    @Test
    public void testConnection1() throws SQLException {
        //Driver driver = new com.mysql.jdbc.Driver();
        //这个在MySQL8里面被废弃了
        //一个坑的地方，因为我装的MySQL是8.0的，老师给的jar包是5.x的，不匹配，所以连接不上，换个高版本jar包就好了
        Driver driver = new com.mysql.cj.jdbc.Driver();
        //com.mysql.jdbc.Driver这个是写死的
        //driver是驱动的意思
        //url:http://localhost:8080/gmall/keyboard.jpg
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8";
        //报错解决链接：https://blog.csdn.net/qq_42815754/article/details/83652253
        //jdbc://mysql 协议
        //localhost：ip地址
        //3306 默认mysql的端口号
        //test: test数据库名
        Properties info = new Properties();
        //将用户名和密码封装在Properties中
        info.setProperty("user","root");
        info.setProperty("password","123456");
        Connection conn = driver.connect(url, info);
        System.out.println(conn);
        //这里就相当于你拿到女生的微信号了，就联系上了(需要url,info进行赋值才行)
    }
}
