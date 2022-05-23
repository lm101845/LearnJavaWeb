package util;

/**
 * @author ����
 * @date 2021��06��23�� 17:19
 */

import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.sql.Connection;
import java.util.Properties;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

/**
 * JDBC������ ʹ��Durid���ӳ�
 */
public class  JDBCUtils {
    private static DataSource ds ;
    static {
        try {
            //1.���������ļ�
            Properties pro = new Properties();
            //ʹ��ClassLoader���������ļ�����ȡ�ֽ�������
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);
            //2.��ʼ�����ӳض���
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * ��ȡ���ӳض���
     */
    public static DataSource getDataSource(){
        return ds;
    }


    /**
     * ��ȡ����Connection����
     */
    public static Connection getConnection() throws SQLException {
        return  ds.getConnection();
    }
}
