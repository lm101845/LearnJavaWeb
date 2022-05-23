package jdbc;

import java.sql.*;

/**
 * @Author liming
 * @Date 2022/5/16 8:45
 **/
//JDBC——查询总记录条数
public class Demo07 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.通过驱动管理器获取连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fruitdb?useSSL=false&serverTimezone=GMT%2B8", "root", "123456");
        //3.编写SQL语句
        String sql = "select count(*)  from t_fruit";
        //4.编写预处理命令对象
        PreparedStatement psmt = conn.prepareStatement(sql);
        //5.执行查询，返回结果集(只有一行一列)
        ResultSet rs = psmt.executeQuery();
        //6.解析结果集
        if(rs.next()){
            int count = rs.getInt(1);
            System.out.println(count);
        }
        //7.释放资源
        rs.close();
        psmt.close();
        conn.close();

    }
}
