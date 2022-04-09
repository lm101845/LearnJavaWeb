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
 * ʹ��PreparedStatement���滻Statement,ʵ�ֶ����ݱ����ɾ�Ĳ���
 *
 * ��ɾ�ģ���
 *
 *
 */
public class PreparedStatementUpdateTest3 {
    //�޸�customers���е�һ����¼
    @Test
    public void testUpdate() {
//        String sql = "delete from customers where id = ?";
        String sql = "update `order` set order_name = ? where order_id = ?";
        //��������޸��������ˣ�Ҳ�ǿ��Ըĵ�
        update(sql, "DD","2");
    }
}
