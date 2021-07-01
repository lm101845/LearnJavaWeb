package demo03;

/**
 * @author ����
 * @date 2021��06��23�� 23:47
 */

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * �������
 *
*/

public class JDBCDemo01 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstm1 = null;
        PreparedStatement pstm2 = null;
        try {
            //1.��ȡ����
            conn = JDBCUtils.getConnection();

            //��������
            conn.setAutoCommit(false);
            //2.����sql
            //2.1 ���� -500
            String sql1 = "update account set balance = balance - ? where id = ?";
            //2.2 ���� +500
            String sql2 = "update account set balance = balance + ? where id = ?";

            //3.��ȡsql����
            pstm1 = conn.prepareStatement(sql1);
            pstm2 = conn.prepareStatement(sql2);

            //4.���ò���
            pstm1.setDouble(1,500);
            pstm1.setInt(2,1);

            pstm2.setDouble(1,500);
            pstm2.setInt(2,2);

            //5.ִ��sql
            pstm1.executeUpdate();

            //�ֶ������쳣
            int i = 3/0;

            pstm2.executeUpdate();
            //�ύ����
            conn.commit();
        } catch (Exception e) {
            //����ع�
            try {
                if(conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstm1,conn);
            JDBCUtils.close(pstm2,null);
        }
    }
}
