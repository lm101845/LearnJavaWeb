package com.atguigu.transaction;

import com.atguigu.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author liming
 * @Date 2022/9/21 9:42
 **/

/**
 * 1.什么叫数据库事务？
 * 事务：一组逻辑操作单元,使数据从一种状态变换到另一种状态。
 * > 一组逻辑操作单元：一个或多个DML操作。
 * <p>
 * 2.事务处理的原则：保证所有事务都作为一个工作单元来执行，即使出现了故障，都不能改变这种执行方式。
 * 当在一个事务中执行多个操作时，要么所有的事务都被提交(commit)，那么这些修改就永久地保存
 * 下来；要么数据库管理系统将放弃所作的所有修改，整个事务回滚(rollback)到最初状态。
 * <p>
 * 3.数据一旦提交，就不可回滚
 * <p>
 * 4.哪些操作会导致数据的自动提交？
 * >DDL[数据库定义语言（Data Definition Language）,DDL]操作一旦执行，都会自动提交。
 * >set autocommit = false 对DDL操作失效(设置了也没用)
 * >DML[数据操纵语言（Data Manipulation Language, DML）]默认情况下，一旦执行，就会自动提交。
 * >我们可以通过set autocommit = false的方式取消DML操作的自动提交。
 * >默认在关闭连接时，会自动的提交数据
 */
public class TransactionTest {
    //******************未考虑数据库事务情况下的转账操作**************************

    /**
     * 针对于数据表user_table来说：
     * AA用户给BB用户转账100
     * <p>
     * update user_table set balance = balance - 100 where user = 'AA';
     * update user_table set balance = balance + 100 where user = 'BB';
     */
    @Test
    public void testUpdate() {
        String sql1 = "update user_table set balance = balance - 100 where user = ?";
        update(sql1, "AA");
        //模拟网络异常
        System.out.println(10 / 0);

        String sql2 = "update user_table set balance = balance + 100 where user = ?";
        update(sql2, "BB");

        System.out.println("转账成功！");
    }

    //通用的增删改操作(2种写法)——version1.0
    //public void update(String sql,Object ...args) {
    public int update(String sql, Object... args) {
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
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
                //我们是从1开始的，所以一定记得 i + 1
            }
            //4.执行
//            ps.execute();
            return ps.executeUpdate();
            //影响了几行数据
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.资源的关闭
            JDBCUtils.closeResource(conn, ps);
        }
        return 0;
    }

    //********************考虑数据库事务后的转账操作*********************
    @Test
    public void testUpdateWithTx() {
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            System.out.println(conn.getAutoCommit());
            //1.取消数据的自动提交功能——DML默认是自动提交的
            conn.setAutoCommit(false);
            String sql1 = "update user_table set balance = balance - 100 where user = ?";
            update(conn, sql1, "AA");
            //模拟网络异常
            System.out.println(10 / 0);

            String sql2 = "update user_table set balance = balance + 100 where user = ?";
            update(conn, sql2, "BB");

            System.out.println("转账成功！");

            //2.提交数据
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //3.回滚数据
            try {
                conn.rollback();
            } catch (Exception err) {
                err.printStackTrace();
            }
        } finally {
            //4.修改其为自动提交数据
            //主要针对于使用数据库连接池的使用
            try {
                conn.setAutoCommit(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            //5.资源关闭
            JDBCUtils.closeResource(conn, null);
            //默认在关闭连接时，会自动的提交数据，所以我们这里手动关闭
        }
    }

    //通用的增删改操作——version2.0
    public int update(Connection conn, String sql, Object... args) {
        //我有几个占位符，你的可变形参就有几个
        //可变形参的个数应该与占位符的个数相同(sql.length)
        PreparedStatement ps = null;
        try {
            //1.预编译SQL语句，返回preparedStatement的实例
            ps = conn.prepareStatement(sql);
            //2.填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
                //我们是从1开始的，所以一定记得 i + 1
            }
            //3.执行
            return ps.executeUpdate();
            //影响了几行数据
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //4.资源的关闭——外面传进来的，你也不要关链接
            JDBCUtils.closeResource(null, ps);
        }
        return 0;
    }
}
