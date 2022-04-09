package util;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @Author liming
 * @Date 2022/4/9 12:03
 **/

public class CommonMethod {
    //通用的增删改操作
    public static void update(String sql,Object ...args) {
        //我有几个占位符，你的可变形参就有几个
        //可变形参的个数应该与占位符的个数相同(sql.length)
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1.获取数据库的连接
            conn = JDBCUtils.getConnection();
            //2.预编译SQL语句，返回preparedStatement的实例
            ps = conn.prepareStatement(sql);
            //3.填充占位符
            for(int i = 0; i < args.length; i++){
                ps.setObject(i + 1 ,args[i]);
                //我们是从1开始的，所以一定记得 i + 1
            }
            //4.执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.资源的关闭
            JDBCUtils.closeResource(conn, ps);
        }
    }
}
