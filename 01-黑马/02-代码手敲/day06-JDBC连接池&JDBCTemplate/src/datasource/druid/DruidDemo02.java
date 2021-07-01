package datasource.druid;

/**
 * @author ����
 * @date 2021��07��01�� 23:26
 */

import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ʹ���µĹ�����
 */
public class DruidDemo02 {
    public static void main(String[] args) {
        /*
         * �����Ӳ�������account�����һ����¼
         */
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            //1.��ȡ����
            conn = JDBCUtils.getConnection();
            //2.����sql
            String sql = "insert into account values(null,?,?)";
            //3.��ȡpstmt����
            pstmt = conn.prepareStatement(sql);
            //4.������ֵ
            pstmt.setString(1,"wangwu");
            pstmt.setDouble(2,3000);
            //5.ִ��sql
            int count = pstmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            JDBCUtils.close(pstmt,conn);
        }
    }
}
