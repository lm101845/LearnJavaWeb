package demo01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author ����
 * @date 2021��06��22�� 22:17
 */
public class JDBCDemo01 {
    public static void main(String[] args) throws Exception{
        //1.��������jar������������ʲô���ݿ⣬�͵���  Ӧ������jar��
        //�����������ӵ���MySQL���ݿ⣬���Ծ͵���MySQL����Jar���ͺ���
        //mysql-connector-java-5.1.37-bin
        //libs�ļ���Ҫ�Ҽ����add as library

        //2.ע��������������ʡ�Բ�д
        //Class.forName("com.mysql.jdbc.Driver");
        //���쳣�׳�ȥ

        //3.��ȡ���ݿ�����Ӷ���
        //connection�ǵ�ǰ��������ݿ�֮�������
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db4","root","123456");

        //4.����SQL���
        String sql = "update account set balance = 5000 where id = 1";

        //5.��ȡִ��sql�Ķ��� Statement
        Statement stmt = conn.createStatement();

        //6.ִ��sql
        //int���͵�ֵ����ʾӰ�������
        int count = stmt.executeUpdate(sql);

        //7.������
        System.out.println(count);
        //1

        //8.ʩ����Դ
        stmt.close();
        conn.close();
    }
}
