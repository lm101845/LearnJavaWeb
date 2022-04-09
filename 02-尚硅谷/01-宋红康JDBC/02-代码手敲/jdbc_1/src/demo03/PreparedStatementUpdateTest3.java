package demo03;

import org.junit.Test;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static util.CommonMethod.update;

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
public class PreparedStatementUpdateTest3 {
    //修改customers表中的一条记录
    @Test
    public void testUpdate() {
//        String sql = "delete from customers where id = ?";
        String sql = "update `order` set order_name = ? where order_id = ?";
        //这个就是修改其他表了，也是可以改的
        update(sql, "DD","2");
    }
}
