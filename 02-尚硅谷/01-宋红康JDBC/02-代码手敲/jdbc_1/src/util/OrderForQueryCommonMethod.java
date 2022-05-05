package util;

import demo04.Order;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * @Author liming
 * @Date 2022/5/5 22:41
 **/
/*
 * 针对于表的字段名与类的属性名不相同的情况：
 * 1. 必须声明sql时，使用类的属性名来命名字段的别名c
 * 2. 使用ResultSetMetaData时，需要使用getColumnLabel()来替换getColumnName(),
 *    获取列的别名。
 *  说明：如果sql中没有给字段其别名，getColumnLabel()获取的就是列名
 */
public class OrderForQueryCommonMethod {
    public static Order orderForQuery(String sql,Object ...args){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for(int i =  0; i < args.length; i++){
                ps.setObject(i+1,args[i]);
            }
            //执行获取结果集
            rs = ps.executeQuery();
            //获取结果集的元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取列数
            int columnCount = rsmd.getColumnCount();
            if(rs.next()){
                Order order = new Order();
                for(int i = 0; i < columnCount; i++){
                    //获取列的列值：通过resultSet
                    Object columnValue = rs.getObject(i + 1);
                    //获取每个列的列名:通过ResultSetMetaData
                    //获取列的列名：getColumnName()——不推荐使用
                    //获取列的别名：getColumnLabel()
                    //String columnName = rsmd.getColumnLabel(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    //通过反射将对象指定的columnName属性赋值为columnValue(通过反射——【最难的地方】)
                    Field field = Order.class.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(order,columnValue);
                }
                return order;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn,ps,rs);
        }
        return null;
    }
}
