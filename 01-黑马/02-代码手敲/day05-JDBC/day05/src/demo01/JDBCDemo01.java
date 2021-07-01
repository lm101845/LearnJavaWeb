package demo01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author 李明
 * @date 2021年06月22日 22:17
 */
public class JDBCDemo01 {
    public static void main(String[] args) throws Exception{
        //1.导入驱动jar包——你连接什么数据库，就导对  应的驱动jar包
        //我们这里连接的是MySQL数据库，所以就导入MySQL驱动Jar包就好了
        //mysql-connector-java-5.1.37-bin
        //libs文件夹要右键点击add as library

        //2.注册驱动——可以省略不写
        //Class.forName("com.mysql.jdbc.Driver");
        //把异常抛出去

        //3.获取数据库的连接对象
        //connection是当前代码和数据库之间的桥梁
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db4","root","123456");

        //4.定义SQL语句
        String sql = "update account set balance = 5000 where id = 1";

        //5.获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();

        //6.执行sql
        //int类型的值，表示影响的行数
        int count = stmt.executeUpdate(sql);

        //7.处理结果
        System.out.println(count);
        //1

        //8.施放资源
        stmt.close();
        conn.close();
    }
}
