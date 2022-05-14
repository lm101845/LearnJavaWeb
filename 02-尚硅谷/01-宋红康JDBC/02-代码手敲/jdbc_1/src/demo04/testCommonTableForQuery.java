package demo04;

import demo04.Customer;
import demo04.Order;
import org.junit.Test;

import java.util.List;

import static util.CommonTableCommonMethod.getInstance;
import static util.CommonTableCommonMethod.getForList;
/**
 * @Author liming
 * @Date 2022/5/14 10:50
 **/
public class testCommonTableForQuery {
    @Test
    public void getGetInstance(){
        String sql = "select id,name,email from customers where id = ?";
        Customer cus = getInstance(Customer.class, sql, 12);
        System.out.println(cus);

        String sql1 = "select order_id orderId,order_name orderName from `order` where order_id = ?";
        Order order = getInstance(Order.class, sql1, 1);
        System.out.println(order);
    }

    @Test
    public void testGetForList(){
        String sql = "select id,name,email from customers where id < ?";
        List<Customer> list = getForList(Customer.class, sql, 12);
        list.forEach(System.out::println);

        String sql1 = "select order_id orderId,order_name orderName from `order` where order_id < ?";
        List<Order> orderList = getForList(Order.class, sql1, 5);
        System.out.println(orderList);
    }
}
