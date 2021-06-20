package junit;

/**
 * @author 李明
 * @date 2021年06月11日 20:13
 */
public class CalculatorTest {
    public static void main(String[] args) {
        //创建对象
        Calculator c = new Calculator();

        //调用
        int result = c.add(1,2);

        //打印
        System.out.println(result);

        int result2 = c.sub(5,2);
        System.out.println(result2);
    }
}
