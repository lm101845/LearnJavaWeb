package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author liming
 * @Date 2022/5/16 8:45
 **/
//JDBC——修改和删除
public class Demo04 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fruitdb?useSSL=false&serverTimezone=GMT%2B8", "root", "123456");
        String sql = "delete from t_fruit  where fid = ?";
        PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setInt(1,33);
        int count = psmt.executeUpdate();
        System.out.println(count > 0 ? "删除成功！" : "删除失败！");

        psmt.close();
        conn.close();
    }
}
