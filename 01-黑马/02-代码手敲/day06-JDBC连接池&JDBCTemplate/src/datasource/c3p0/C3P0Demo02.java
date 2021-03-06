package c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 李明
 * @date 2021年07月01日 17:33
 */
public class C3P0Demo02 {
    public static void main(String[] args) throws SQLException {
        //1.获取DataSource,使用默认配置
        //DataSource ds = new ComboPooledDataSource();

        //1.1获取DataSource,使用指定名称配置
        DataSource ds = new ComboPooledDataSource("otherc3p0");

        //2.获取连接
        for(int i = 1;i <= 10;i++){
            Connection conn = ds.getConnection();
            System.out.println(i + ":"+conn);
            if(i == 5){
                conn.close();  //归还连接到连接池中
            }
        }
    }
}
