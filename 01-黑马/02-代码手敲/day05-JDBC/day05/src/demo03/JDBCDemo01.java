package demo03;

/**
 * @author 李明
 * @date 2021年06月23日 23:47
 */

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 事务操作
 *
*/

public class JDBCDemo01 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstm1 = null;
        PreparedStatement pstm2 = null;
        try {
            //1.获取连接
            conn = JDBCUtils.getConnection();

            //开启事务
            conn.setAutoCommit(false);
            //2.定义sql
            //2.1 张三 -500
            String sql1 = "update account set balance = balance - ? where id = ?";
            //2.2 李四 +500
            String sql2 = "update account set balance = balance + ? where id = ?";

            //3.获取sql对象
            pstm1 = conn.prepareStatement(sql1);
            pstm2 = conn.prepareStatement(sql2);

            //4.设置参数
            pstm1.setDouble(1,500);
            pstm1.setInt(2,1);

            pstm2.setDouble(1,500);
            pstm2.setInt(2,2);

            //5.执行sql
            pstm1.executeUpdate();

            //手动制造异常
            int i = 3/0;

            pstm2.executeUpdate();
            //提交事务
            conn.commit();
        } catch (Exception e) {
            //事务回滚
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
