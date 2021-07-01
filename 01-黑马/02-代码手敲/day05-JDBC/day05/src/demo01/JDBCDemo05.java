package demo01;

/**
 * @author 李明
 * @date 2021年06月23日 12:47
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 执行DDL语句
 */
public class JDBCDemo05 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");

            //2.获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///db4", "root", "123456");

            //3.定义sql
            String sql = "create table student(id int,name varchar(20))";

            //4.获取执行sql对象
            stmt = conn.createStatement();

            //5.执行sql
            int count = stmt.executeUpdate(sql);

            //6.处理结果
            System.out.println(count);
//            if(count > 0){
//                System.out.println("创建成功");
//            }else{
//                System.out.println("创建失败");
//            }
//            DDL语句是没有返回结果的，所以count是0！！！
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //7.释放资源
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
