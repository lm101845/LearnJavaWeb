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
 * JDBC�����࣬ʹ��Druid���ӳ�
 * */
public class JDBCUtils {
    private static DataSource ds;
//    private static final com.alibaba.druid.pool.DruidDataSourceFactory DruidDataSourceFactory = ;

    static {
        try{
            //1.���������ļ�
            Properties pro = new Properties();
            //ʹ��ClassLoader�����������ļ�����ȡ�ֽ�������
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);
            //2.��ʼ�����ӳض���
            ds = DruidDataSourceFactory.createDataSource(pro);
        }catch (IOException e){
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
    //�����෽�����鶼����ɾ�̬��
    public static Connection getConnection() throws SQLException {
        return  ds.getConnection();
    }
}
