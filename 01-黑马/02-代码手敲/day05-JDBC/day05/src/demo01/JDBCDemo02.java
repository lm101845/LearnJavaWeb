package demo01;

/**
 * @author ����
 * @date 2021��06��23�� 2:20
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * account�� ���һ����¼ insert ���
 */

public class JDBCDemo02 {
    public static void main(String[] args) {
        Statement stmt = null;
        Connection conn = null;
        try {
            //1. ע������
            Class.forName("com.mysql.jdbc.Driver");
            //2. ����sql
            String sql = "insert into account values(null,'wangwu',3000)";
            //3.��ȡConnection����
            //conn = DriverManager.getConnection("jdbc:mysql:///db4", "root", "123456");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db4","root","123456");
            //4.��ȡִ��sql�Ķ��� Statement
            stmt = conn.createStatement();
            //5.ִ��sql
            int count = stmt.executeUpdate(sql);//Ӱ�������
            //6.������
            System.out.println(count);
            if(count > 0){
                System.out.println("��ӳɹ���");
            }else{
                System.out.println("���ʧ�ܣ�");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //stmt.close();
            //7. �ͷ���Դ
            //�����ָ���쳣
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}

//�Լ�д�ı���
//public class JDBCDemo02 {
//    public static void main(String[] args) throws ClassNotFoundException {
//        //����stmt�������򣬲�Ȼfinally�����Ҳ���stmt
//        Statement stmt = null;
//        Connection conn = null;
//
//        try {
//            //1.ע������
//            //Class.forName("com.mysql.jdbc.Driver");
//
//            //2.����sql
//            String sql = "insert into account values(null,'����',3000)";
//
//            //3.��ȡConnection����
//            conn = DriverManager.getConnection("jdbc:mysql:///db4","root","123456");
//
//            //4.��ȡִ��sql�Ķ��� Statement
//            stmt = conn.createStatement();
//
//            //5.ִ��sql
//            int count = stmt.executeUpdate(sql);  //Ӱ�������
//
//            //6.�������������������ӡһ�¾�����
//            System.out.println(count);
//            if(count > 0){
//                System.out.println("��ӳɹ�");
//            }else{
//                System.out.println("���ʧ��");
//            }
//            //7.�ͷ���Դ(������ִ�гɹ�����ʧ�ܣ����Ҫʩ����Դ)
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally{
//            //��ʩ�ź����stmt(��Ϊstmt���ɺ����conn��ȡ��)
//            //stmt.close();
//            //Ϊ�˱����ָ���쳣
//            if(stmt != null){
//                try {
//                    stmt.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            if(conn != null){
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//}
