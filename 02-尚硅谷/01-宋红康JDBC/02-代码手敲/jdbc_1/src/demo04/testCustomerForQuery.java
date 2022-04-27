package demo04;

import org.junit.Test;
import static util.CustomerForQueryCommonMethod.queryForCustomers;

/**
 * @Author liming
 * @Date 2022/4/27 17:00
 **/
public class testCustomerForQuery {
    @Test
    public void testQueryForCustomers(){
        String sql = "select id,name,birth,email from customers where id = ?";
        Customer customer =  queryForCustomers(sql,13);
        System.out.println(customer);
    }
}
