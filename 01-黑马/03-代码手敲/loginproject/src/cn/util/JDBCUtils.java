package cn.util;

/**
 * @Author liming
 * @Date 2022/4/23 17:44
 **/

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC工具类，使用Druid连接池
 * */
public class JDBCUtils {
    private static DataSource ds;
//    private static final com.alibaba.druid.pool.DruidDataSourceFactory DruidDataSourceFactory = ;

    static {
        try{
            //1.加载配置文件
            Properties pro = new Properties();
            //使用ClassLoader来加载配置文件，获取字节输入流
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);
            //2.初始化连接池对象
            ds = DruidDataSourceFactory.createDataSource(pro);
        }catch (IOException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取连接池对象
     */
    public static DataSource getDataSource(){
        return ds;
    }
    /**
     * 获取连接Connection对象
     */
    //工具类方法建议都定义成静态的
    public static Connection getConnection() throws SQLException {
        return  ds.getConnection();
    }
}
