package dao.impl;

import dao.UserDao;
import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author liming
 * @Date 2022/5/13 13:03
 **/
public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils2.getDataSource());

    @Override
//    public List<User> findAll(){
//        //使用JDBC来操作数据库...
//        //1.定义sql
//        String sql = "select * from user";
//        List<User> users = template.query(sql,new BeanPropertyRowMapper<User>(User.class));
//        return users;
//    }
    public List<User> findAll() throws SQLException {
        //变量的抽取
        ResultSet rs = null;
        Statement stmt = null;
        Connection conn = null;
        List<User> list = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");

            //2.获取连接
            conn = DriverManager.getConnection("jdbc:mysql:///day17", "root", "123456");

            //3.定义sql
            String sql = "select * from user";

            //4.获取执行sql的对象
            stmt = conn.createStatement();

            //5.执行sql
            rs = stmt.executeQuery(sql);

            //6.遍历结果集，封装对象，装载集合
            User user = null;
            list = new ArrayList<User>();
            while(rs.next()){
                //获取数据
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                String qq = rs.getString("qq");
                String email = rs.getString("email");

                // 创建emp对象,并赋值
                user = new User();
                user.setId(id);
                user.setName(name);
                user.setGender(gender);
                user.setAge(age);
                user.setAddress(address);
                user.setQq(qq);
                user.setEmail(email);

                //装载集合
                list.add(user);

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(rs != null){
                try{
                    rs.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if(stmt != null){
                try{
                    stmt.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if(conn != null){
                try{
                    conn.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
}
