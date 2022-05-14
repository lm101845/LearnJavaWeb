package util;

/**
 * @Author liming
 * @Date 2022/5/14 10:37
 **/

import demo04.Customer;
import util.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;


public  class CommonTableCommonMethod {
    /**
     * 使用preparedStatement实现针对于不同表的通用的查询操作,返回表中的一条记录
     */
    public static <T>T getInstance(Class<T> clazz,String sql,Object ...args){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //1.创建连接
            conn = JDBCUtils.getConnection();
            //2.预编译SQL语句
            ps = conn.prepareStatement(sql);
            //3.填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            //4.拿到结果集
            rs = ps.executeQuery();
            //因为只返回一个对象，我们查的时候也就只查一次，所以我们就写if了,否则用while(执行多次)

            //5.获取结果集的元数据：ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();
            //6.通过ResultSetData获取结果集中的列数
            int columnCount = rsmd.getColumnCount();
            if (rs.next()) {
                //横向来看只有一条数据，只造一个对象即可
                //处理结果集一行数据中的每一个列
                //T t = clazz.newInstance();  //方法已过时
                T t = clazz.getDeclaredConstructor().newInstance();
                //7.获取结果集的列数
                for (int i = 0; i < columnCount; i++) {
                    //获取列值
                    Object columnValue = rs.getObject(i + 1);

                    //8.获取每个列的列名——不推荐使用，推荐用别名
                    //String columnName = rsmd.getColumnName(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    //给t对象指定的columnName属性赋值为columnValue(通过反射——【最难的地方】)
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;  //没查到数据就return null
    }

    /**
     * 使用preparedStatement实现针对于不同表的通用的查询操作,返回表中的多条记录
     */
    public static <T> List<T> getForList(Class<T> clazz, String sql, Object ...args){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //1.创建连接
            conn = JDBCUtils.getConnection();
            //2.预编译SQL语句
            ps = conn.prepareStatement(sql);
            //3.填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            //4.拿到结果集
            rs = ps.executeQuery();
            //因为只返回一个对象，我们查的时候也就只查一次，所以我们就写if了,否则用while(执行多次)

            //5.获取结果集的元数据：ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();
            //6.通过ResultSetData获取结果集中的列数
            int columnCount = rsmd.getColumnCount();
            //创建集合对象
            ArrayList<T> list = new ArrayList<>();
            while (rs.next()) {
                //横向来看只有一条数据，只造一个对象即可
                //处理结果集一行数据中的每一个列:给t对象指定的属性赋值
                //T t = clazz.newInstance();  //方法已过时
                T t = clazz.getDeclaredConstructor().newInstance();
                //7.获取结果集的列数
                for (int i = 0; i < columnCount; i++) {
                    //获取列值
                    Object columnValue = rs.getObject(i + 1);

                    //8.获取每个列的列名——不推荐使用，推荐用别名
                    //String columnName = rsmd.getColumnName(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    //给t对象指定的columnName属性赋值为columnValue(通过反射——【最难的地方】)
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;  //没查到数据就return null
    }
}
