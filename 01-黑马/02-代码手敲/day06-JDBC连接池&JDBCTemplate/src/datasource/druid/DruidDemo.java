package datasource.druid2;

/**
 * @author ����
 * @date 2021��07��01�� 19:35
 */

//https://blog.csdn.net/weixin_42323802/article/details/82726267
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * Druid��ʾ
 */
public class DruidDemo<is> {
    public static void main(String[] args) throws Exception {
        //1.����jar��
        //2.���������ļ�
        //3.���������ļ�
        Properties pro = new Properties();
        InputStream is = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);
        //4.��ȡ���ӳض���
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);

        //5.��ȡ����
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }
}
