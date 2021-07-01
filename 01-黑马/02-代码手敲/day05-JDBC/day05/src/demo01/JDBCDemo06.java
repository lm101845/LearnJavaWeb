package demo01;

/**
 * @author 李明
 * @date 2021年06月23日 12:47
 */

import java.sql.*;

/**
 * 执行DDL语句
 */
public class JDBCDemo06 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");

            //2.获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///db4", "root", "123456");

            //3.定义sql
            String sql = "select * from account";

            //4.获取执行sql对象
            stmt = conn.createStatement();

            //5.执行sql
            //int count = stmt.executeUpdate(sql);
            rs = stmt.executeQuery(sql);

            //6.处理结果——获取第一行的数据
            //6.1 让游标向下移动一行
            rs.next();
            //6.2获取数据
            int id = rs.getInt(1);
            String name = rs.getString("name");
            double balance = rs.getDouble(3);
            System.out.println(id + "---" + name + "---" + balance);

            //6.1 让游标向下移动一行
            rs.next();
            //6.2获取数据
            int id2 = rs.getInt(1);
            String name2 = rs.getString("name");
            double balance2 = rs.getDouble(3);
            System.out.println(id2 + "---" + name2 + "---" + balance2);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //7.释放资源
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
