package c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author ����
 * @date 2021��07��01�� 17:33
 */
public class C3P0Demo02 {
    public static void main(String[] args) throws SQLException {
        //1.��ȡDataSource,ʹ��Ĭ������
        //DataSource ds = new ComboPooledDataSource();

        //1.1��ȡDataSource,ʹ��ָ����������
        DataSource ds = new ComboPooledDataSource("otherc3p0");

        //2.��ȡ����
        for(int i = 1;i <= 10;i++){
            Connection conn = ds.getConnection();
            System.out.println(i + ":"+conn);
            if(i == 5){
                conn.close();  //�黹���ӵ����ӳ���
            }
        }
    }
}
