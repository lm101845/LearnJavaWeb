import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author liming
 * @Date 2022/5/22 16:59
 **/

//��ȡ�ⲿ�������ļ��������ӳ�
public class Demo04Druid {
    public static void main(String[] args) throws SQLException, IOException {
        Properties properties = new Properties();
        InputStream is = Demo04Druid.class.getClassLoader().getResourceAsStream("jdbc.properties");
        properties.load(is);
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(properties.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(properties.getProperty("jdbc.url"));
        dataSource.setUsername(properties.getProperty("jdbc.username"));
        dataSource.setPassword(properties.getProperty("jdbc.password"));

        dataSource.setInitialSize(Integer.parseInt(properties.getProperty("jdbc.initSize")));
        dataSource.setMaxActive(Integer.parseInt(properties.getProperty("jdbc.maxActive")));
        dataSource.setMaxWait(Integer.parseInt(properties.getProperty("jdbc.maxWait")));
        //֤�����㣺
        //1. ��close�����Ӷ���û�������رգ����ǽ�״̬��������Ϊ����״̬��Ȼ��Żس��ӣ������´λ�ȡ���Ӷ����������ᱻ�ظ�ʹ��
        //2. û��close�����Ӷ���ᱻһֱռ�ã���ô�´μ�����ȡ���Ӷ����ǲ����ȡ���������ģ�hashcodeû���ظ���ֻ����һ�Σ�
        for (int i = 0; i < 10; i++) {
            DruidPooledConnection conn1 = dataSource.getConnection();
            System.out.println(conn1 + "--------555555-------->" + i);
        }
    }
}
