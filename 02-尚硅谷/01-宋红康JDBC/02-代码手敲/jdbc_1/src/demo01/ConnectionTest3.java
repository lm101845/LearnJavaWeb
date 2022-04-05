package demo01;

import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author liming
 * @Date 2022/4/5 12:08
 **/
public class ConnectionTest3 {
    //���ӷ�ʽ����ʹ��DriverManager(���ǽӿ�����)�滻Driver(��������ֱ�ӽ��в�����)
    @Test
    public void testConnection3() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        //1.��ȡDriver��ʵ�������
        Class  clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();
        //2.�ṩ����3�����ӵĻ�����Ϣ
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8";
        String user = "root";
        String password = "123456";
        //3.ע������
        DriverManager.registerDriver(driver);
        //4.��ȡ����
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }
}
