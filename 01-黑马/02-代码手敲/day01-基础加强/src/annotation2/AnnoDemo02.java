package annotation2;

/**
 * @Author liming
 * @Date 2022/4/12 23:19
 **/
/**
 * JDK��Ԥ�����һЩע��
 * 		* @Override	����ⱻ��ע���ע�ķ����Ƿ��Ǽ̳��Ը���(�ӿ�)��
 * 		* @Deprecated����ע���ע�����ݣ���ʾ�ѹ�ʱ
 * 		* @SuppressWarnings��ѹ�ƾ��桪���༭��������д�Ĵ�������ʾ������Ϣ���㿴�Ų�ˬ�����뿴������Ϳ���д���
 * 	            *һ�㴫�ݲ���all 	@SuppressWarnings("all")
 *
 *
 */
@SuppressWarnings("all")
//����������������еľ���Ͷ�û����
public class AnnoDemo02 {
    @Override
    public String toString(){
        return super.toString();
    }

    @Deprecated
    public void show1(){
        //��ȱ�ݣ�������Ҳ����ɾ�����򲻼��ݵͰ汾
    }
    @MyAnno(show = "")
    public void show2(){
        //���show1����
    }
    public void demo(){
        show1();
    }
}
