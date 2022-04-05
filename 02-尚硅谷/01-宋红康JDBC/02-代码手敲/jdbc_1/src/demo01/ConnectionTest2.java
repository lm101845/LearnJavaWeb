package demo01;

import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author liming
 * @Date 2022/4/5 12:08
 **/
public class ConnectionTest2 {
    //���ӷ�ʽ�����Է�ʽһ�ĵ����������µĳ����в����ֵ�������api,ʹ�ó�����и��õ���ֲ��
    @Test
    public void testConnection2() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
      //1.��ȡDriver��ʵ���������������ʹ�÷���
        Class  clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();
        //JAVA9֮���Ƽ�ʹ��newInstance()����

        //2.�ṩҪ���ӵ����ݿ�
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8";
        Properties info = new Properties();
        //3.�ṩ������Ҫ���û���������
        info.setProperty("user","root");
        info.setProperty("password","123456");
        //4.��ȡ����
        Connection conn = driver.connect(url, info);
        System.out.println(conn);
    }
}
