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
public class Demo03 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Fruit fruit = new Fruit(33,"猕猴桃","猕猴桃是水果之王");

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fruitdb?useSSL=false&serverTimezone=GMT%2B8", "root", "123456");
        String sql = "update t_fruit set fname = ?,remark = ? where fid = ?";
        PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setString(1,fruit.getFname());
        psmt.setString(2,fruit.getRemark());
        psmt.setInt(3,fruit.getFid());
        int count = psmt.executeUpdate();
        System.out.println(count > 0 ? "修改成功！" : "修改失败！");

        psmt.close();
        conn.close();
    }
}
