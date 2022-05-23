import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author liming
 * @Date 2022/5/22 16:59
 **/

//��ȡ�ⲿ�������ļ��������ӳ�
public class Demo05Druid {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        InputStream is = Demo05Druid.class.getClassLoader().getResourceAsStream("jdbc2.properties");
        properties.load(is);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        //֤�����㣺
        //1. ��close�����Ӷ���û�������رգ����ǽ�״̬��������Ϊ����״̬��Ȼ��Żس��ӣ������´λ�ȡ���Ӷ����������ᱻ�ظ�ʹ��
        //2. û��close�����Ӷ���ᱻһֱռ�ã���ô�´μ�����ȡ���Ӷ����ǲ����ȡ���������ģ�hashcodeû���ظ���ֻ����һ�Σ�
        for (int i = 0; i < 10; i++) {
            Connection conn1 = dataSource.getConnection();
            System.out.println(conn1 + "--------66666-------->" + i);
        }
    }
}
