package com.atguigu4.conn;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author liming
 * @Date 2022/11/5 14:19
 **/
public class DBCPTest {
    /**
     * 测试DBCP的数据库连接池技术
     */
    //方式一：不推荐
    @Test
    public void testGetConnection() throws SQLException {
        //创建DBCP的数据库连接池
        BasicDataSource source = new BasicDataSource();
        //设置基本信息
        source.setDriverClassName("com.mysql.jdbc.Driver");
        source.setUrl("jdbc:mysql://localhost:3305/test?serverTimezone=GMT%2B8&useSSL=false&rewriteBatchedStatements=true");
        source.setUsername("root");
        source.setPassword("123456");
        //还可以设置其他涉及数据库连接池管理的相关属性
        source.setInitialSize(10);
        source.setMaxActive(10);
        //等等......
        Connection conn = source.getConnection();
        System.out.println(conn + "--conn");
    }

    //方式二：使用配置文件
    @Test
    public void testGetConnection1() throws Exception {
        Properties pros = new Properties();
        //方式1：使用类的加载器加载文件
        //InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
        //方式2：推荐，使用配置文件
        FileInputStream is = new FileInputStream(new File("src/dbcp.properties"));
        pros.load(is);
        DataSource source = BasicDataSourceFactory.createDataSource(pros);
        Connection conn = source.getConnection();
        System.out.println(conn + "--dbcp");
    }
}
