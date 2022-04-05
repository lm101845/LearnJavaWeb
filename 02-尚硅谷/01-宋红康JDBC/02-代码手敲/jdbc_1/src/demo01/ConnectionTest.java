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
public class ConnectionTest {
    //���ӷ�ʽһ
    @Test
    public void testConnection1() throws SQLException {
        //Driver driver = new com.mysql.jdbc.Driver();
        //�����MySQL8���汻������
        //һ���ӵĵط�����Ϊ��װ��MySQL��8.0�ģ���ʦ����jar����5.x�ģ���ƥ�䣬�������Ӳ��ϣ������߰汾jar���ͺ���
        Driver driver = new com.mysql.cj.jdbc.Driver();
        //com.mysql.jdbc.Driver�����д����
        //driver����������˼
        //url:http://localhost:8080/gmall/keyboard.jpg
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8";
        //���������ӣ�https://blog.csdn.net/qq_42815754/article/details/83652253
        //jdbc://mysql Э��
        //localhost��ip��ַ
        //3306 Ĭ��mysql�Ķ˿ں�
        //test: test���ݿ���
        Properties info = new Properties();
        //���û����������װ��Properties��
        info.setProperty("user","root");
        info.setProperty("password","123456");
        Connection conn = driver.connect(url, info);
        System.out.println(conn);
        //������൱�����õ�Ů����΢�ź��ˣ�����ϵ����(��Ҫurl,info���и�ֵ����)
    }
}
