package annotation2;

/**
 * @Author liming
 * @Date 2022/4/23 13:05
 **/

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ������Ҫִ�е��������ͷ�����
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Pro {
    //ע�����涨��ľ���һЩ���󷽷�
    String className();
    String methodName();
}
