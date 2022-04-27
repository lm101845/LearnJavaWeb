package simpleproject;

/**
 * @Author liming
 * @Date 2022/4/23 14:03
 **/
public class Calculator {
    //加法
    @Check
    public void add(){
        String str = null;
        str.toString();
        //这个方法会出现空指针异常
        System.out.println("1 + 0 =" + (1 + 0));
    }
    //减法
    @Check
    public void sub(){
        System.out.println("1 - 0 =" + (1 - 0));
    }

    //乘法
    @Check
    public void mul(){
        System.out.println("1 * 0 =" + (1 * 0));
    }

    //除法
    @Check
    public void div(){
        System.out.println("1 / 0 =" + (1 / 0));
    }

    public void show(){
        System.out.println("永无bug...");
    }
}
