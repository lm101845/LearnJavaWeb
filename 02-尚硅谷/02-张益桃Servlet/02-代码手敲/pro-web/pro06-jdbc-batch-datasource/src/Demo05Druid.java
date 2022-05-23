import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author liming
 * @Date 2022/5/22 16:59
 **/

//读取外部的配置文件设置连接池
public class Demo05Druid {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        InputStream is = Demo05Druid.class.getClassLoader().getResourceAsStream("jdbc2.properties");
        properties.load(is);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        //证明两点：
        //1. 被close的连接对象并没有真正关闭，而是将状态重新设置为空闲状态，然后放回池子，这样下次获取连接对象，这个对象会被重复使用
        //2. 没有close的连接对象会被一直占用，那么下次继续获取连接对象，是不会获取到这个对象的（hashcode没有重复，只出现一次）
        for (int i = 0; i < 10; i++) {
            Connection conn1 = dataSource.getConnection();
            System.out.println(conn1 + "--------66666-------->" + i);
        }
    }
}
