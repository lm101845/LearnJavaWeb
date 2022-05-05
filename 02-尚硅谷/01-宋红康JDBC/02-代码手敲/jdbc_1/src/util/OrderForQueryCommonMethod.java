package util;

import demo04.Order;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * @Author liming
 * @Date 2022/5/5 22:41
 **/
/*
 * ����ڱ���ֶ������������������ͬ�������
 * 1. ��������sqlʱ��ʹ������������������ֶεı���c
 * 2. ʹ��ResultSetMetaDataʱ����Ҫʹ��getColumnLabel()���滻getColumnName(),
 *    ��ȡ�еı�����
 *  ˵�������sql��û�и��ֶ��������getColumnLabel()��ȡ�ľ�������
 */
public class OrderForQueryCommonMethod {
    public static Order orderForQuery(String sql,Object ...args){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for(int i =  0; i < args.length; i++){
                ps.setObject(i+1,args[i]);
            }
            //ִ�л�ȡ�����
            rs = ps.executeQuery();
            //��ȡ�������Ԫ����
            ResultSetMetaData rsmd = rs.getMetaData();
            //��ȡ����
            int columnCount = rsmd.getColumnCount();
            if(rs.next()){
                Order order = new Order();
                for(int i = 0; i < columnCount; i++){
                    //��ȡ�е���ֵ��ͨ��resultSet
                    Object columnValue = rs.getObject(i + 1);
                    //��ȡÿ���е�����:ͨ��ResultSetMetaData
                    //��ȡ�е�������getColumnName()�������Ƽ�ʹ��
                    //��ȡ�еı�����getColumnLabel()
                    //String columnName = rsmd.getColumnLabel(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    //ͨ�����佫����ָ����columnName���Ը�ֵΪcolumnValue(ͨ�����䡪�������ѵĵط���)
                    Field field = Order.class.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(order,columnValue);
                }
                return order;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(conn,ps,rs);
        }
        return null;
    }
}
