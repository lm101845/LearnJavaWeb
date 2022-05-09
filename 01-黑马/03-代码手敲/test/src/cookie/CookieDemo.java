package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author liming
 * @Date 2022/5/9 12:59
 **/
@WebServlet("/cookieDemo")
public class CookieDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        //获取cookie信息
        //Request对象的作用——获取请求消息
        System.out.println("test项目xxx");
        Cookie[] cs = request.getCookies();
        //4.获取数据，遍历Cookies
        if(cs != null){
            for(Cookie c:cs){
                String name = c.getName();
                String value = c.getValue();
                System.out.println(name + ":" + value);
                //内部是使用map的结构来存储数据的
            }
        }
    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException{
        this.doPost(request, response);
    }
}
