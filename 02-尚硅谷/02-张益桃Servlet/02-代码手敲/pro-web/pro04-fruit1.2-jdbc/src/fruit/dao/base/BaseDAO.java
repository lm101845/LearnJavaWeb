package fruit.dao.base;

import java.sql.*;

/**
 * @Author liming
 * @Date 2022/5/22 12:50
 **/
public abstract class BaseDAO {
    //抽象类，不能直接new，你要是用，就得继承
    //抽象类允许你有构造方法，但是不允许你直接new
    public final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public final String URL = "jdbc:mysql://localhost:3306/fruitdb?useSSL=false&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true";
    public final String USER = "root";
    public final String PASSWORD = "123456";

    protected ResultSet rs = null;
    protected Connection conn = null;
    protected PreparedStatement psmt = null;

    protected Connection getConn() {
        try {
            //1.加载驱动
            Class.forName(DRIVER);
            //2.通过驱动管理器获取连接对象
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void close(ResultSet rs, PreparedStatement psmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (psmt != null) {
                psmt.close();
            }
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //执行更新，返回影响行数
    protected int executeUpdate(String sql, Object... params) {
        try {
            conn = getConn();

            psmt = conn.prepareStatement(sql);
            if (params != null && params.length > 0) {
                for (int i = 0; i < params.length; i++) {
                    psmt.setObject(i+1,params[i]);
                }
            }
            return psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, psmt, conn);
        }
        return 0;
    }
}
