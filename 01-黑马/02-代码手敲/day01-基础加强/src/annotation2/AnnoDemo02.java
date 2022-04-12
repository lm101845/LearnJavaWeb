package annotation2;

/**
 * @Author liming
 * @Date 2022/4/12 23:19
 **/
/**
 * JDK中预定义的一些注解
 * 		* @Override	：检测被该注解标注的方法是否是继承自父类(接口)的
 * 		* @Deprecated：该注解标注的内容，表示已过时
 * 		* @SuppressWarnings：压制警告——编辑器会在你写的代码上提示警告信息，你看着不爽，不想看到警告就可以写这个
 * 	            *一般传递参数all 	@SuppressWarnings("all")
 *
 *
 */
@SuppressWarnings("all")
//这样这个类里面所有的警告就都没有了
public class AnnoDemo02 {
    @Override
    public String toString(){
        return super.toString();
    }

    @Deprecated
    public void show1(){
        //有缺陷，但是你也不能删，否则不兼容低版本
    }
    @MyAnno(show = "")
    public void show2(){
        //替代show1方法
    }
    public void demo(){
        show1();
    }
}
