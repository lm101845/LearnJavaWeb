package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author liming
 * @Date 2022/5/16 8:45
 **/
//JDBC——查询所有的库存
public class Demo05 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.通过驱动管理器获取连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fruitdb?useSSL=false&serverTimezone=GMT%2B8", "root", "123456");
        //3.编写SQL语句
        String sql = "select *  from t_fruit";
        //4.编写预处理命令对象
        PreparedStatement psmt = conn.prepareStatement(sql);
        //5.执行查询，返回结果集
        ResultSet rs = psmt.executeQuery();
        //6.解析结果集
        //System.out.println(rs);
        List<Fruit> fruitList = new ArrayList<>();
        while(rs.next()){
            //1.表示读取当前行的第一列的数据
            //getInt 因为这一列是int类型，所以使用getInt
            //int fid = rs.getInt("fid");   //也可以写label
            int fid = rs.getInt(1);
            String fname = rs.getString(2);
            int price = rs.getInt(3);
            int fcount = rs.getInt(4);
            String remark = rs.getString(5);

            Fruit fruit = new Fruit(fid,fname,price,fcount,remark);
            fruitList.add(fruit);
        }
        //7.释放资源
        rs.close();
        psmt.close();
        conn.close();

        fruitList.forEach(System.out::println);
    }
}
