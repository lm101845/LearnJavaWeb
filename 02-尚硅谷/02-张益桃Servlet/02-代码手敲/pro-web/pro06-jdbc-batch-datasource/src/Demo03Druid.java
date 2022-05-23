import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.sql.SQLException;

/**
 * @Author liming
 * @Date 2022/5/22 16:59
 **/

//��֤���ӳصĸ����������ʼ����С����󼤻����������ȴ�ʱ��
public class Demo03Druid {
    public static void main(String[] args) throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/fruitdb?useSSL=false&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        dataSource.setInitialSize(2);
        dataSource.setMaxActive(5);
        dataSource.setMaxWait(5000);
        //֤�����㣺
        //1. ��close�����Ӷ���û�������رգ����ǽ�״̬��������Ϊ����״̬��Ȼ��Żس��ӣ������´λ�ȡ���Ӷ����������ᱻ�ظ�ʹ��
        //2. û��close�����Ӷ���ᱻһֱռ�ã���ô�´μ�����ȡ���Ӷ����ǲ����ȡ���������ģ�hashcodeû���ظ���ֻ����һ�Σ�
        for (int i = 0; i < 10; i++) {
            DruidPooledConnection conn1 = dataSource.getConnection();
            System.out.println(conn1 + "---------------->" + i);
        }
    }
}
