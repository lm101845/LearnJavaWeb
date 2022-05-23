import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author liming
 * @Date 2022/5/22 16:59
 **/

//读取外部的配置文件设置连接池
public class Demo04Druid {
    public static void main(String[] args) throws SQLException, IOException {
        Properties properties = new Properties();
        InputStream is = Demo04Druid.class.getClassLoader().getResourceAsStream("jdbc.properties");
        properties.load(is);
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(properties.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(properties.getProperty("jdbc.url"));
        dataSource.setUsername(properties.getProperty("jdbc.username"));
        dataSource.setPassword(properties.getProperty("jdbc.password"));

        dataSource.setInitialSize(Integer.parseInt(properties.getProperty("jdbc.initSize")));
        dataSource.setMaxActive(Integer.parseInt(properties.getProperty("jdbc.maxActive")));
        dataSource.setMaxWait(Integer.parseInt(properties.getProperty("jdbc.maxWait")));
        //证明两点：
        //1. 被close的连接对象并没有真正关闭，而是将状态重新设置为空闲状态，然后放回池子，这样下次获取连接对象，这个对象会被重复使用
        //2. 没有close的连接对象会被一直占用，那么下次继续获取连接对象，是不会获取到这个对象的（hashcode没有重复，只出现一次）
        for (int i = 0; i < 10; i++) {
            DruidPooledConnection conn1 = dataSource.getConnection();
            System.out.println(conn1 + "--------555555-------->" + i);
        }
    }
}
