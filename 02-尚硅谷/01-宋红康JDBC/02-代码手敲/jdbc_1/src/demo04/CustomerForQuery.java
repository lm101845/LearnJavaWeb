package demo04;

import org.junit.Test;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @Author liming
 * @Date 2022/4/27 14:48
 * @Description 针对于Customer表的查询操作
 **/


public class CustomerForQuery {
    @Test
    public void testQuery1(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            //1.创建连接
            conn = JDBCUtils.getConnection();

            //2.预编译SQL语句
            String sql = "select id,name,email,birth from customers where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1,1);

            //3.执行并返回结果集(不需要里面传SQL了)
            resultSet = ps.executeQuery();

            //4.处理结果集
            if(resultSet.next()){
                //next()方法作用：判断结果集的下一条是否有数据，如果有数据返回true,并指针下移，如果返回false，指针不会下移
                //获取当前这条数据的各个字段值
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date birth = resultSet.getDate(4);

                //方式一：有点Low，不建议这样写
                //System.out.println("id=" + id + ",name=" + name + "email=" + email + ",birth=" + birth);

                //方式二：用对象
                //Object[] data = new Object[]{id,name,email,birth};

                //方式三：用集合:将数据封装为一个对象(推荐方式)
                Customer customer = new Customer(id, name, email, birth);
                System.out.println(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.关闭资源
            JDBCUtils.closeResource(conn,ps,resultSet);
        }
    }
}
