package com.atguigu4.conn;


import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;


import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @Author liming
 * @Date 2022/11/5 15:20
 **/

//我们实际用的基本都是这个
public class DruidTest {
    @Test
    public void GetConnection() throws Exception {
        //DataSource source = new DruidDataSource();
        Properties pros = new Properties();
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
        pros.load(is);
        DataSource source = DruidDataSourceFactory.createDataSource(pros);
        Connection conn = source.getConnection();
        System.out.println(conn + "--druid");
    }
}
