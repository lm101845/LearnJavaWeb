package util;

/**
 * @author ����
 * @date 2021��06��23�� 17:19
 */

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC������
 */
public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    //Ϊʲô�Ǿ�̬���أ���Ϊ����ֻ�о�̬�������ܱ���̬�����������

    /**
     * �ļ��Ķ�ȡ��ֻ��Ҫ��ȡһ�μ����õ���Щֵ����ʹ�þ�̬�����
     * ��̬������������ļ��ض����أ�����ֻ��ִ��һ��
     */
    static{
        //��ȡ��Դ�ļ�����ȡֵ
        //����ʹ�úܶ��ַ�ʽ��properties�����ļ������ڴ浱��
        try {
            //1.Properties������
            Properties pro = new Properties();

            //��ȡsrc·���µ��ļ��ķ�ʽ---->ClassLoader�������
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL res = classLoader.getResource("jdbc.properties");
            String path = res.getPath();
            //System.out.println(path);

            //2.�����ļ�
            //pro.load(new FileReader("src/jdbc.properties"));
            pro.load(new FileReader(path));
            //�ھ�̬�������ֻ�ܴ����쳣�������ף���Ϊ��Ҫ��������

            //3.��ȡ���ݣ���ֵ
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            //4.ע������
            Class.forName("driver");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * ��ȡ����
     * @return java.sql.Connection
    */
//    public static Connection getConnetcion(String url,String user,String password) throws SQLException{
//        //����Ҫ����һ��Connection����
//        //������ַ������ܹ�д��������᲻ͨ��
//        //return DriverManager.getConnection("jdbc:mysql:///db4","root","123456");
//
//        //return DriverManager.getConnection(url,user,password);
//        //����ͨ�����εķ�ʽ����������Ҳ���Ǻܺá������ݲ������鷳
//
//    }

//    public static Connection getConnetcion(String url,String user,String password) throws SQLException{
//        //�ҼȲ��봫�Σ�����ʵ��һ�ֶ�̬��Ч��(��֤�������ͨ����)
//        //�������������һ�������ļ��������¼����
//        //�������������仯��ʱ�����Ǹ������ļ�����
//        return DriverManager.getConnection(url, user, password);
//    }

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url, user, password);
    }

    /**
     * �ͷ���Դ
     * @param stmt
     * @param conn 
    */
    public static void close(Statement stmt,Connection conn){
        //��Ҫ�ͷ��ĸ���Դ����ø�����
        //ִ����ɾ�ĵ�ʱ��Ҫ�ͷ�stmt��conn����
        //ִ�в�ѯ����ʱ��Ҫ�ͷ�rs,stmt��conn����
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rs,Statement stmt, Connection conn){
        //����Ƿ���������
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


}
