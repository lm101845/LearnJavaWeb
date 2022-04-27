package demo04;

import org.junit.Test;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @Author liming
 * @Date 2022/4/27 14:48
 * @Description �����Customer��Ĳ�ѯ����
 **/


public class CustomerForQuery {
    @Test
    public void testQuery1(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            //1.��������
            conn = JDBCUtils.getConnection();

            //2.Ԥ����SQL���
            String sql = "select id,name,email,birth from customers where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1,1);

            //3.ִ�в����ؽ����(����Ҫ���洫SQL��)
            resultSet = ps.executeQuery();

            //4.��������
            if(resultSet.next()){
                //next()�������ã��жϽ��������һ���Ƿ������ݣ���������ݷ���true,��ָ�����ƣ��������false��ָ�벻������
                //��ȡ��ǰ�������ݵĸ����ֶ�ֵ
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date birth = resultSet.getDate(4);

                //��ʽһ���е�Low������������д
                //System.out.println("id=" + id + ",name=" + name + "email=" + email + ",birth=" + birth);

                //��ʽ�����ö���
                //Object[] data = new Object[]{id,name,email,birth};

                //��ʽ�����ü���:�����ݷ�װΪһ������(�Ƽ���ʽ)
                Customer customer = new Customer(id, name, email, birth);
                System.out.println(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.�ر���Դ
            JDBCUtils.closeResource(conn,ps,resultSet);
        }
    }
}
