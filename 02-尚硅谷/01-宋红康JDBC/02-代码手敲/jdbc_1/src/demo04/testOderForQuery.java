package demo04;

import org.junit.Test;

import static util.OrderForQueryCommonMethod.orderForQuery;

/**
 * @Author liming
 * @Date 2022/5/5 23:04
 **/
public class testOderForQuery {
    @Test
    public void testOrderForQuery(){
        String sql = "select order_id orderId,order_name orderName,order_date orderDate from `order` where order_id = ?";
        Order order = orderForQuery(sql, 1);
        System.out.println(order);
    }
}
