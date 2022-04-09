package util;

/**
 * @Author liming
 * @Date 2022/4/9 13:59
 **/

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @Description:�������ݿ�Ĺ�����
 * @Param:
 * @return:
 */
public class JDBCUtils {
    /** 
    * @Description: ��ȡ���ݿ������
    * @Param: []
    * @return: java.sql.Connection
    */
    public static Connection getConnection() throws Exception{
        //1.��ȡ�����ļ��е�4��������Ϣ
        //ͨ����ļ�����������
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        //���ַ�ʽҲ���Ի��һ��ϵͳ�������

        Properties props = new Properties();
        props.load(is);

        String user = props.getProperty("user");
        String password = props.getProperty("password");
        String url = props.getProperty("url");
        String driverClass = props.getProperty("driverClass");


        //2.��������
        Class.forName(driverClass);

        //3.��ȡ����
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    /**
    * @Description:�ر����Ӻ�Statement�Ĳ���
    * @Param: []
    * @return: void
    */
    public static void closeResource(Connection conn, Statement ps){
        try {
            if(ps != null){
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
