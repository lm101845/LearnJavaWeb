import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.sql.SQLException;

/**
 * @Author liming
 * @Date 2022/5/22 16:59
 **/

//验证连接池的各项参数：初始化大小、最大激活数量、最大等待时间
public class Demo03Druid {
    public static void main(String[] args) throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/fruitdb?useSSL=false&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        dataSource.setInitialSize(2);
        dataSource.setMaxActive(5);
        dataSource.setMaxWait(5000);
        //证明两点：
        //1. 被close的连接对象并没有真正关闭，而是将状态重新设置为空闲状态，然后放回池子，这样下次获取连接对象，这个对象会被重复使用
        //2. 没有close的连接对象会被一直占用，那么下次继续获取连接对象，是不会获取到这个对象的（hashcode没有重复，只出现一次）
        for (int i = 0; i < 10; i++) {
            DruidPooledConnection conn1 = dataSource.getConnection();
            System.out.println(conn1 + "---------------->" + i);
        }
    }
}
