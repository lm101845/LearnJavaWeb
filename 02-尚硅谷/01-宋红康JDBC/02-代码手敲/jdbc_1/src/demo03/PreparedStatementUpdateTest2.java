package demo03;

import org.junit.Test;
import util.JDBCUtils;

import java.io.InputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Properties;

/**
 * @Author liming
 * @Date 2022/4/9 12:03
 **/
/*
 * 使用PreparedStatement来替换Statement,实现对数据表的增删改操作
 *
 * 增删改；查
 *
 *
 */
public class PreparedStatementUpdateTest2 {
    //修改customers表中的一条记录
    @Test
    public void testUpdate() {
        //选中这段代码按住ctrl+alt+T即可用try..catch进行包裹
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1.获取数据库的连接
            conn = JDBCUtils.getConnection();
            //2.预编译SQL语句，返回preparedStatement的实例
            String sql = "update customers set name = ? where id = ?";
            ps = conn.prepareStatement(sql);
            //3.填充占位符
            ps.setObject(1, "mozhate");
            ps.setObject(2, 18);
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
