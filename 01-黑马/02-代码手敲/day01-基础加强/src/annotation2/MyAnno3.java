package annotation2;

/**
 * @Author liming
 * @Date 2022/4/23 12:37
 **/

import java.lang.annotation.*;

/**
 Ԫע�⣺��������ע���ע��
 * @Target������ע���ܹ����õ�λ��
 *    * ElementTypeȡֵ��
 * 		* TYPE����������������
 * 		* METHOD�����������ڷ�����
 * 		* FIELD�����������ڳ�Ա������
 * @Retention������ע�ⱻ�����Ľ׶�
 * @Documented������ע���Ƿ񱻳�ȡ��api�ĵ���
 * @Inherited������ע���Ƿ�����̳�
 *
 */
@Target(value = {ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})  //��ʾ��Anno3���ע��ֻ������������
@Retention(RetentionPolicy.RUNTIME)  //��ǰ��������ע�⣬�ᱣ����class�ֽ����ļ��У�����JVM��ȡ��
@Documented
@Inherited
public @interface MyAnno3 {
}
