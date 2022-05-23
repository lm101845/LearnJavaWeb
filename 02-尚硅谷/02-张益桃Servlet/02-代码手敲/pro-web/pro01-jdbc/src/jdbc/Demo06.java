package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author liming
 * @Date 2022/5/16 8:45
 **/
//JDBC——查询指定fid的库存记录
public class Demo06 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.通过驱动管理器获取连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fruitdb?useSSL=false&serverTimezone=GMT%2B8", "root", "123456");
        //3.编写SQL语句
        String sql = "select *  from t_fruit where fid = ?";
        //4.编写预处理命令对象
        PreparedStatement psmt = conn.prepareStatement(sql);
        //5.填充参数
        psmt.setInt(1,1);
        //6.执行查询，返回结果集
        ResultSet rs = psmt.executeQuery();
        //6.解析结果集
        if(rs.next()){
            //因为只有一条数据，用if也行
            //1.表示读取当前行的第一列的数据
            int fid = rs.getInt(1);
            String fname = rs.getString(2);
            int price = rs.getInt(3);
            int fcount = rs.getInt(4);
            String remark = rs.getString(5);
            Fruit fruit = new Fruit(fid,fname,price,fcount,remark);
            System.out.println(fruit);
        }
        //7.释放资源
        rs.close();
        psmt.close();
        conn.close();

    }
}
