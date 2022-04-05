package test;

import junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author 李明
 * @date 2021年06月11日 20:21
 */
public class CalculatorTest {
    /**
     * 初始化方法:
     *  一般用于资源的申请，用于所有测试方法在执行之前都会先执行该方法
     * */
    @Before
    public void init(){
        System.out.println("init...");
    }
    /**
     * 释放资源的方法：
     *  在所有测试方法执行完后，都会自动执行该方法
     * */
    @After
    public void close(){
        System.out.println("closed...");
    }
    /** 
     * 测试add方法
    */
    @Test
    public void testAdd(){
        //System.out.println("我被执行了");
        System.out.println("testAdd...");
        //1.创建计算器对象
        Calculator c = new Calculator();

        //2.调用add方法
        int result = c.add(1,2);
        //System.out.println(result);
        //一般情况下我们不会在单元测试里面进行输出，我们会做一个断言的操作

        //3.断言  我断言这个结果是3
        Assert.assertEquals(3,result);
    }

    @Test
    public void testSub(){
        //1.创建计算器对象
        Calculator c = new Calculator();

        int result = c.sub(1,2);
        System.out.println("testSub方法被执行了...");
        Assert.assertEquals(-1,result);
    }
}
