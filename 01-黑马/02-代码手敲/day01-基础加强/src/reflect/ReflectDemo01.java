package reflect;

/**
 * @Author liming
 * @Date 2022/4/5 16:03
 **/

import domain.Person;

/**
 获取Class对象的方式：
 1. Class.forName("全类名")：将字节码文件加载进内存，返回Class对象
 2. 类名.class：通过类名的属性class获取
 3. 对象.getClass()：getClass()方法在Object类中定义着。

 */
public class ReflectDemo01 {
    public static void main(String[] args) throws Exception {
        //1.Class.forName("全类名")
        Class cls1 = Class.forName("domain.Person");
        System.out.println(cls1);
        //class domain.Person

        //2.类名.class
        Class<Person> cls2 = Person.class;
        System.out.println(cls2);

        //3.对象.getClass()
        Person p = new Person();
        Class cls3 = p.getClass();
        System.out.println(cls3);

        //用==比较三个对象
        System.out.println(cls1 == cls2);  //true
        System.out.println(cls1 == cls3);  //true
        /**
         * 结论：
         * 		同一个字节码文件(*.class)在一次程序运行过程中，只会被加载一次，
         * 		不论通过哪一种方式获取的Class对象都是同一个。
         * */
    }
}
