package demo01;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author liming
 * @Date 2022/4/5 12:08
 **/
public class ConnectionTest5 {
    //���ӷ�ʽ��(���հ�)�������ݿ�������Ҫ��4��������Ϣ�����������ļ��У�ͨ����ȡ�����ļ��ķ�ʽ��ȡ����
    /**
     * ���ַ����ô���
     *  1.ʵ�������������ķ��룬ʵ���˽���(����Ӳ������)
     *  2. �����Ҫ�޸������ļ���Ϣ�����Ա���������´��
     * */
    @Test
    public void testConnection5() throws SQLException, ClassNotFoundException, IOException {
        //1.��ȡ�����ļ��е�4��������Ϣ
        //ͨ����ļ�����������
//        InputStream is = ConnectionTest5.class.getClassLoader().getResourceAsStream("jdbc.properties");
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        //ClassLoader����������ʱ��Java�ද̬���ص�JVM�У�����ClassLoader��JRE��һ���֡�
        // ��ˣ�����ClassLoader�Ĵ��ڣ�JVM�����˽�ײ��ļ����ļ�ϵͳ��������Java����
        //���ַ�ʽҲ���Ի��һ��ϵͳ�������

        Properties props = new Properties();
        //Properties��Java.util.Properties����Java��һ���Ƚ���Ҫ���࣬��Ҫ���ڶ�ȡJava�������ļ�
        props.load(is);

        String user = props.getProperty("user");
        String password = props.getProperty("password");
        String url = props.getProperty("url");
        String driverClass = props.getProperty("driverClass");


        //2.��������
        Class.forName(driverClass);

        //3.��ȡ����
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }
}
