package com.atguigu4.conn;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;
import org.junit.Test;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author liming
 * @Date 2022/11/5 13:16
 **/
public class C3P0Test {
    //方式一：
    @Test
    public void testGetConnection() throws Exception {
        //获取C3P0数据库连接池
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass( "com.mysql.jdbc.Driver" );
        cpds.setJdbcUrl( "jdbc:mysql://localhost:3305/test?serverTimezone=GMT%2B8&useSSL=false&rewriteBatchedStatements=true" );
        cpds.setUser("root");
        cpds.setPassword("123456");

        //通过设置相关的参数，对数据库连接池进行管理
        //设置初始时数据库连接池中的连接数
        cpds.setInitialPoolSize(10);
        Connection conn = cpds.getConnection();
        System.out.println(conn + "--c3po");

        //销毁C3P0连接池，一般我们不会做这种操作的
        //DataSources.destroy(cpds);
    }

    //方式二：使用配置文件

    @Test
    public void testGetConnection1() throws SQLException {
        ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");
        Connection conn = cpds.getConnection();
        System.out.println(conn + "--conn");
    }
}
