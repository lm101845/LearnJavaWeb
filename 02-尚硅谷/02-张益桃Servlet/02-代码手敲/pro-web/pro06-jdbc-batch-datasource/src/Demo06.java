import java.sql.*;

/**
 * @Author liming
 * @Date 2022/5/22 19:21
 **/
public class Demo06 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //���������һ�� ���Ҫִ������������URL����Ҫ���һ��������rewriteBatchedStatements=true
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fruitdb?useSSL=false&serverTimezone=GMT%2B8&rewriteBatchedStatements=true", "root", "123456");
        int fid = 3;
        String sql = "select * from t_fruit where fid = " + fid;   //��һ���������У���0����Ĭ�������ˡ�
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
