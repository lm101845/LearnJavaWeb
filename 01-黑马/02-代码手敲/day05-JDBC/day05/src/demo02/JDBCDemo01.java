package demo02;

/**
 * @author 李明
 * @date 2021年06月23日 18:51
 */


import util.JDBCUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 练习：
 * 		* 需求：
 * 			1. 通过键盘录入用户名和密码
 * 			2. 判断用户是否登录成功
 */

public class JDBCDemo01 {
    public static void main(String[]args){
        //1.键盘录入，接收用户名和密码
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入用户名：");
        String username = sc.nextLine();

        System.out.println("请输入密码：");
        String password = sc.nextLine();
        //2.调用方法，返回布尔
        boolean flag = new JDBCDemo01().login(username,password);
        //3.判断结果，输出不同语句
        if(flag){
            //登陆成功
            System.out.println("登陆成功");
        }else{
            System.out.println("用户名或密码错误");
        }
    }

    /**
     * 登录方法
     */
    public boolean login(String username,String password){
        if(username == null || password == null){
            return false;
        }
        //连接数据库判断是否登陆成功

        //1.获取连接
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            conn = JDBCUtils.getConnection();
            //2.定义sql
            String sql = "select * from user where username = '"+username + "' and password = '"+password + "'";
            System.out.println(sql);

            //3.获取执行sql的对象
            stmt = conn.createStatement();

            //4.执行查询
            rs = stmt.executeQuery(sql);

            //5.判断
            //如果有下一行，则返回true
//            if(rs.next()){
//                return true;
//            }else{
//                return false;
//            }
            return rs.next();
            //代码这样写比上面好
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,conn);
        }
        return false;
    }
}
