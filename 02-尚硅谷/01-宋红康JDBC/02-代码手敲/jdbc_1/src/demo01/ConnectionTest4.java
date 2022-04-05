package demo01;

import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author liming
 * @Date 2022/4/5 12:08
 **/
public class ConnectionTest4 {
    //���ӷ�ʽ�ģ����������ϵ��Ż�����ֻ�Ǽ���������������ʽע��������
    @Test
    public void testConnection4() throws SQLException, ClassNotFoundException {
        //1.�ṩ3�����ӵĻ�����Ϣ
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8";
        String user = "root";
        String password = "123456";

        //2.��ȡDriver��ʵ������󡪡����Ҳ�ǿ���ʡ�Եģ�������mysqlҲ�������ˣ�������
        //�����ⲽ��Ҫʡ�ԣ���Ϊmysql����ʡ���ˣ�����oracleû�а���ʡ�ԣ���ͨ�ýǶ�˵����Ҫʡ
        Class.forName("com.mysql.cj.jdbc.Driver");

        //��������д�ˣ���(mysql)����������
        //3.��ȡ����
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }
}
