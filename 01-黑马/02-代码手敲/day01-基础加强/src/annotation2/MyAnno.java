package annotation2;

/**
 * @Author liming
 * @Date 2022/4/12 23:33
 **/
public @interface MyAnno {
    //public abstract String show();
    //������󷽷�����ע�������
    int age();
    String name() default "����";
//    Person per();
//    MyAnno2 anno2();
//    String[] strs();
}
