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
 * ʹ��PreparedStatement���滻Statement,ʵ�ֶ����ݱ����ɾ�Ĳ���
 *
 * ��ɾ�ģ���
 *
 *
 */
public class PreparedStatementUpdateTest2 {
    //�޸�customers���е�һ����¼
    @Test
    public void testUpdate() {
        //ѡ����δ��밴סctrl+alt+T������try..catch���а���
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1.��ȡ���ݿ������
            conn = JDBCUtils.getConnection();
            //2.Ԥ����SQL��䣬����preparedStatement��ʵ��
            String sql = "update customers set name = ? where id = ?";
            ps = conn.prepareStatement(sql);
            //3.���ռλ��
            ps.setObject(1, "mozhate");
            ps.setObject(2, 18);
            //4.ִ��
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.��Դ�Ĺر�
            JDBCUtils.closeResource(conn, ps);
        }
    }
}
