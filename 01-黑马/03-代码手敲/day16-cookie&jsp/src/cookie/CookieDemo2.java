package cookie; /**
 * @Author liming
 * @Date 2022/5/9 8:55
 **/

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/cookieDemo2")
public class CookieDemo2 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //3.获取Cookie(也是服务端获取)
        //Request对象的作用——获取请求消息
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
