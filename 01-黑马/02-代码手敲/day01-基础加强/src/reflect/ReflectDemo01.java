package reflect;

/**
 * @Author liming
 * @Date 2022/4/5 16:03
 **/

import domain.Person;

/**
 ��ȡClass����ķ�ʽ��
 1. Class.forName("ȫ����")�����ֽ����ļ����ؽ��ڴ棬����Class����
 2. ����.class��ͨ������������class��ȡ
 3. ����.getClass()��getClass()������Object���ж����š�

 */
public class ReflectDemo01 {
    public static void main(String[] args) throws Exception {
        //1.Class.forName("ȫ����")
        Class cls1 = Class.forName("domain.Person");
        System.out.println(cls1);
        //class domain.Person

        //2.����.class
        Class<Person> cls2 = Person.class;
        System.out.println(cls2);

        //3.����.getClass()
        Person p = new Person();
        Class cls3 = p.getClass();
        System.out.println(cls3);

        //��==�Ƚ���������
        System.out.println(cls1 == cls2);  //true
        System.out.println(cls1 == cls3);  //true
        /**
         * ���ۣ�
         * 		ͬһ���ֽ����ļ�(*.class)��һ�γ������й����У�ֻ�ᱻ����һ�Σ�
         * 		����ͨ����һ�ַ�ʽ��ȡ��Class������ͬһ����
         * */
    }
}
