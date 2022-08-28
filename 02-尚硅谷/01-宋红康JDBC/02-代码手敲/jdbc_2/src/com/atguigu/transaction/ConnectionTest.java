package com.atguigu.transaction;

import com.atguigu.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @Author liming
 * @Date 2022/8/28 11:43
 **/
public class ConnectionTest {
    @Test
    public void testGetConnection() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        System.out.println(conn);
    }
}
