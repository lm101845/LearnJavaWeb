package demo01;

/**
 * @author ����
 * @date 2021��06��23�� 12:47
 */

import java.sql.*;

/**
 * ִ��DDL���
 */
public class JDBCDemo06 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //1.ע������
            Class.forName("com.mysql.jdbc.Driver");

            //2.��ȡ���Ӷ���
            conn = DriverManager.getConnection("jdbc:mysql:///db4", "root", "123456");

            //3.����sql
            String sql = "select * from account";

            //4.��ȡִ��sql����
            stmt = conn.createStatement();

            //5.ִ��sql
            //int count = stmt.executeUpdate(sql);
            rs = stmt.executeQuery(sql);

            //6.������������ȡ��һ�е�����
            //6.1 ���α������ƶ�һ��
            rs.next();
            //6.2��ȡ����
            int id = rs.getInt(1);
            String name = rs.getString("name");
            double balance = rs.getDouble(3);
            System.out.println(id + "---" + name + "---" + balance);

            //6.1 ���α������ƶ�һ��
            rs.next();
            //6.2��ȡ����
            int id2 = rs.getInt(1);
            String name2 = rs.getString("name");
            double balance2 = rs.getDouble(3);
            System.out.println(id2 + "---" + name2 + "---" + balance2);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //7.�ͷ���Դ
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
}
