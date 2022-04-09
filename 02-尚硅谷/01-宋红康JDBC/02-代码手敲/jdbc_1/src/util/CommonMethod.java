package util;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @Author liming
 * @Date 2022/4/9 12:03
 **/

public class CommonMethod {
    //ͨ�õ���ɾ�Ĳ���
    public static void update(String sql,Object ...args) {
        //���м���ռλ������Ŀɱ��βξ��м���
        //�ɱ��βεĸ���Ӧ����ռλ���ĸ�����ͬ(sql.length)
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1.��ȡ���ݿ������
            conn = JDBCUtils.getConnection();
            //2.Ԥ����SQL��䣬����preparedStatement��ʵ��
            ps = conn.prepareStatement(sql);
            //3.���ռλ��
            for(int i = 0; i < args.length; i++){
                ps.setObject(i + 1 ,args[i]);
                //�����Ǵ�1��ʼ�ģ�����һ���ǵ� i + 1
            }
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
