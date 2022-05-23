import java.sql.*;

/**
 * @Author liming
 * @Date 2022/5/22 19:21
 **/
public class Demo06 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //批处理操作一： 如果要执行批处理任务，URL中需要添加一个参数：rewriteBatchedStatements=true
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fruitdb?useSSL=false&serverTimezone=GMT%2B8&rewriteBatchedStatements=true", "root", "123456");
        int fid = 3;
        String sql = "select * from t_fruit where fid = " + fid;   //第一列是自增列，填0它就默认自增了。
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if(rs.next()){
            System.out.println(rs.getString("fname"));
            System.out.println(rs.getInt(3));
            System.out.println(rs.getInt("fcount"));
            System.out.println(rs.getString("remark"));
        }
    }
}
