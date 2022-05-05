package util;

import demo04.Customer;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * @Author liming
 * @Date 2022/4/27 16:33
 **/

//��������Customer���ͨ�ò���
public class CustomerForQueryCommonMethod {
    public static Customer queryForCustomers(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //1.��������
            conn = JDBCUtils.getConnection();
            //2.Ԥ����SQL���
            ps = conn.prepareStatement(sql);
            //3.���ռλ��
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            //4.�õ������
            rs = ps.executeQuery();
            //��Ϊֻ����һ���������ǲ��ʱ��Ҳ��ֻ��һ�Σ��������Ǿ�дif��,������while(ִ�ж��)

            //5.��ȡ�������Ԫ���ݣ�ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();
            //6.ͨ��ResultSetData��ȡ������е�����
            int columnCount = rsmd.getColumnCount();
            if (rs.next()) {
                //��������ֻ��һ�����ݣ�ֻ��һ�����󼴿�
                //��������һ�������е�ÿһ����
                Customer cust = new Customer();
                //7.��ȡ�����������
                for (int i = 0; i < columnCount; i++) {
                    //��ȡ��ֵ
                    Object columnValue = rs.getObject(i + 1);

                    //8.��ȡÿ���е������������Ƽ�ʹ�ã��Ƽ��ñ���
                    //String columnName = rsmd.getColumnName(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    //��cust����ָ����columnName���Ը�ֵΪcolumnValue(ͨ�����䡪�������ѵĵط���)
                    Field field = Customer.class.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(cust, columnValue);
                }
                return cust;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;
    }
}
