package jdbc;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author liming
 * @Date 2022/5/16 8:14
 **/
public class Demo02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.通过驱动管理器获取连接对象
        //url表示和数据库通信的地址
        //如果url中需要带参数，则从第二个参数开始用&连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fruitdb?useSSL=false&serverTimezone=GMT%2B8", "root", "123456");
        //3.编写SQL语句
        //id fname price fcount remark
        String sql = "insert into t_fruit values(0,?,?,?,?)";   //第一列是自增列，填0它就默认自增了。
        //我需要把SQL语句运输到数据库去执行
        //4.创建预处理命令对象
        PreparedStatement psmt = conn.prepareStatement(sql);
        //conn相当于是大马路，连接java和数据库，而psmt相当于大马路上的小车子
        //小车子可以帮我们把SQL语句运输给数据库去执行
        //5.填充参数
        psmt.setString(1,"榴莲");
        psmt.setInt(2,15);
        psmt.setInt(3,100);
        psmt.setString(4,"榴莲是一种神奇的水果");
        //6.执行更新(增删改都称为更新),返回影响的行数
        int count = psmt.executeUpdate();
        System.out.println(count > 0 ? "添加成功!":"添加失败！");
        //7.释放资源(关闭连接,先关闭psmt,后关闭conn)
        psmt.close();  //先关闭小车
        conn.close();  //再关闭马路
    }
}
