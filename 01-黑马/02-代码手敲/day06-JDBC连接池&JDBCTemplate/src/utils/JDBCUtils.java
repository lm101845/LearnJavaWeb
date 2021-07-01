package utils;

/**
 * @author ����
 * @date 2021��07��01�� 20:59
 */

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Druid���ӳصĹ�����
 */
public class JDBCUtils {
    //����һ����Ա����
    private static DataSource ds;

    //�������Ա�������г�ʼ����ֵ
    static {
        try {
            //1.���������ļ�
            Properties pro = new Properties();
            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            //2.��ȡDataSource
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * ��ȡ����
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
        //��������쳣���ܷ��������Խ��쳣�ܳ�ȥ
    }

    /**
     * �ͷ���Դ
     */
    public static void close(Statement stmt, Connection conn){
//            if(stmt != null){
//                try{
//                    stmt.close();  //�黹����
//                    //����������Ͱ��쳣�������
//                }catch (SQLException e){
//                    e.printStackTrace();
//                }
//            }

        //��д��
        //�������2�������ģ���Ҳ�������������ģ�ֻ������һ�������Ҳ���ֵ�Ϳ����ˣ��򻯱���
        close(null,stmt,conn);
    }

    //����һ������
    public static void close(ResultSet rs,Statement stmt, Connection conn){
        if(rs != null){
            try{
                rs.close();  //�黹����
                //����������Ͱ��쳣�������
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        if(stmt != null){
            try{
                stmt.close();  //�黹����
                //����������Ͱ��쳣�������
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * ��ȡ���ӳط���
     */

    public static DataSource getDataSource(){
        return  ds;
    }
}
