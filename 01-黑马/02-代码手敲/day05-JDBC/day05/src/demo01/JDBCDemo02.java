package demo01;

/**
 * @author 李明
 * @date 2021年06月23日 2:20
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * account表 添加一条记录 insert 语句
 */

public class JDBCDemo02 {
    public static void main(String[] args) {
        Statement stmt = null;
        Connection conn = null;
        try {
            //1. 注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2. 定义sql
            String sql = "insert into account values(null,'wangwu',3000)";
            //3.获取Connection对象
            //conn = DriverManager.getConnection("jdbc:mysql:///db4", "root", "123456");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db4","root","123456");
            //4.获取执行sql的对象 Statement
            stmt = conn.createStatement();
            //5.执行sql
            int count = stmt.executeUpdate(sql);//影响的行数
            //6.处理结果
            System.out.println(count);
            if(count > 0){
                System.out.println("添加成功！");
            }else{
                System.out.println("添加失败！");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //stmt.close();
            //7. 释放资源
            //避免空指针异常
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}

//自己写的报错
//public class JDBCDemo02 {
//    public static void main(String[] args) throws ClassNotFoundException {
//        //提升stmt的作用域，不然finally里面找不到stmt
//        Statement stmt = null;
//        Connection conn = null;
//
//        try {
//            //1.注册驱动
//            //Class.forName("com.mysql.jdbc.Driver");
//
//            //2.定义sql
//            String sql = "insert into account values(null,'王五',3000)";
//
//            //3.获取Connection对象
//            conn = DriverManager.getConnection("jdbc:mysql:///db4","root","123456");
//
//            //4.获取执行sql的对象 Statement
//            stmt = conn.createStatement();
//
//            //5.执行sql
//            int count = stmt.executeUpdate(sql);  //影响的行数
//
//            //6.处理结果——我们这里打印一下就行了
//            System.out.println(count);
//            if(count > 0){
//                System.out.println("添加成功");
//            }else{
//                System.out.println("添加失败");
//            }
//            //7.释放资源(无论是执行成功还是失败，最后都要施放资源)
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally{
//            //先施放后面的stmt(因为stmt是由后面的conn获取的)
//            //stmt.close();
//            //为了避免空指针异常
//            if(stmt != null){
//                try {
//                    stmt.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            if(conn != null){
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//}
