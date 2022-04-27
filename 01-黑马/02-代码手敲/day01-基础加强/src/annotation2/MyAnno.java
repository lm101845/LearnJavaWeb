package annotation2;

/**
 * @Author liming
 * @Date 2022/4/12 23:33
 **/
public @interface MyAnno {
    //public abstract String show();
    //这个抽象方法就是注解的属性
    int age();
    String name() default "张三";
//    Person per();
//    MyAnno2 anno2();
//    String[] strs();
}
