package cn.test;

import cn.domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @Author liming
 * @Date 2022/4/27 14:26
 **/
public class BeanUtilsTest {
    @Test
    public void test(){
        User user = new User();
        try {
            BeanUtils.setProperty(user,"username","zhangsan");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(user);
    }
}
