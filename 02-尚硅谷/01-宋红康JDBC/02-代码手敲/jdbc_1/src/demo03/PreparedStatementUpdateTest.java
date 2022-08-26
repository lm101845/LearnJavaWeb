package demo03;

import demo01.ConnectionTest5;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

/**
 * @Author liming
 * @Date 2022/4/9 12:03
 **/
/*
 * ʹ��PreparedStatement���滻Statement,ʵ�ֶ����ݱ����ɾ�Ĳ���
 *
 * ��ɾ�ģ���
 *
 *
 */
public class PreparedStatementUpdateTest {
    //��customers�������һ����¼
    @Test
    //�漰����Դ�رգ���Ҫ��throws����try...catch
    public void testInsert() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1.��ȡ�����ļ��е�4��������Ϣ
            //ͨ����ļ�����������
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

            Properties props = new Properties();
            props.load(is);

            String user = props.getProperty("user");
            String password = props.getProperty("password");
            String url = props.getProperty("url");
            String driverClass = props.getProperty("driverClass");


            //2.��������
            Class.forName(driverClass);

            //3.��ȡ����
            conn = DriverManager.getConnection(url, user, password);
            System.out.println(conn);

            //4.Ԥ����SQL��䣬����PreparedStatementʵ��
            String sql = "insert into customers(name,email,birth)values(?,?,?)";//?:ռλ��
            //�����?��ռλ��
            //����Ϊ��д����ռλ�����������Ž����statement�ı׶ˣ����Է�ֹSQLע��
            ps = conn.prepareStatement(sql);

            //5.���ռλ��(java�����ݿ⽻����������1��ʼ)
            ps.setString(1, "nezha111");
            ps.setString(2, "nezha111@gmail.com");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse("1000-01-01");
            ps.setDate(3, new Date(date.getTime()));

            //6.ִ�в���
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //7.��Դ�ر�
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
}
