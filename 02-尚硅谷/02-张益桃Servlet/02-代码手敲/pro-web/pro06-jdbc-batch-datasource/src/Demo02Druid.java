import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Author liming
 * @Date 2022/5/22 16:59
 **/

//��֤���ӳ��е�connection�����ظ�ʹ��
public class Demo02Druid {
    public static void main(String[] args) throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/fruitdb?useSSL=false&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        //֤�����㣺
        //1. ��close�����Ӷ���û�������رգ����ǽ�״̬��������Ϊ����״̬��Ȼ��Żس��ӣ������´λ�ȡ���Ӷ����������ᱻ�ظ�ʹ��
        //2. û��close�����Ӷ���ᱻһֱռ�ã���ô�´μ�����ȡ���Ӷ����ǲ����ȡ���������ģ�hashcodeû���ظ���ֻ����һ�Σ�
        for (int i = 0; i < 5; i++) {
            DruidPooledConnection conn1 = dataSource.getConnection();
            DruidPooledConnection conn2 = dataSource.getConnection();

            System.out.println(conn1 + "----time" + i);
            System.out.println(conn2 + "----time" + i);
            System.out.println("\n");
            if(i%3==0){
                conn1.close();
                conn2.close();
            }
        }
    }
}
