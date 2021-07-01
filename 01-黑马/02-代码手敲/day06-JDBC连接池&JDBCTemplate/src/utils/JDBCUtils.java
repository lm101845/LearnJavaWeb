package utils;

/**
 * @author 李明
 * @date 2021年07月01日 20:59
 */

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Druid连接池的工具类
 */
public class JDBCUtils {
    //定义一个成员变量
    private static DataSource ds;

    //对这个成员变量进行初始化赋值
    static {
        try {
            //1.加载配置文件
            Properties pro = new Properties();
            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            //2.获取DataSource
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
        //警告别人异常可能发生，所以将异常跑出去
    }

    /**
     * 释放资源
     */
    public static void close(Statement stmt, Connection conn){
//            if(stmt != null){
//                try{
//                    stmt.close();  //归还连接
//                    //我们在这里就把异常给处理掉
//                }catch (SQLException e){
//                    e.printStackTrace();
//                }
//            }

        //简化写法
        //我如果是2个参数的，我也调用三个参数的，只不过第一个参数我不给值就可以了，简化编码
        close(null,stmt,conn);
    }

    //再来一个重载
    public static void close(ResultSet rs,Statement stmt, Connection conn){
        if(rs != null){
            try{
                rs.close();  //归还连接
                //我们在这里就把异常给处理掉
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        if(stmt != null){
            try{
                stmt.close();  //归还连接
                //我们在这里就把异常给处理掉
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取连接池方法
     */

    public static DataSource getDataSource(){
        return  ds;
    }
}
