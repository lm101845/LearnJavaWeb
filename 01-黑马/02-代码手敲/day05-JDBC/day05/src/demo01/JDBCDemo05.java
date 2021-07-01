package demo01;

/**
 * @author ����
 * @date 2021��06��23�� 12:47
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ִ��DDL���
 */
public class JDBCDemo05 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //1.ע������
            Class.forName("com.mysql.jdbc.Driver");

            //2.��ȡ���Ӷ���
            conn = DriverManager.getConnection("jdbc:mysql:///db4", "root", "123456");

            //3.����sql
            String sql = "create table student(id int,name varchar(20))";

            //4.��ȡִ��sql����
            stmt = conn.createStatement();

            //5.ִ��sql
            int count = stmt.executeUpdate(sql);

            //6.������
            System.out.println(count);
//            if(count > 0){
//                System.out.println("�����ɹ�");
//            }else{
//                System.out.println("����ʧ��");
//            }
//            DDL�����û�з��ؽ���ģ�����count��0������
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //7.�ͷ���Դ
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
}
