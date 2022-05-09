package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author liming
 * @Date 2022/5/9 8:41
 **/

/**
 *
 * Cookie快速入门
 *
 */
@WebServlet("/cookieDemo5")
public class CookieDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        //1.创建Cookie对象——我们是站在服务器角度编程的
        Cookie c1 = new Cookie("msg","你好");
        //设置path,让当前服务器下部署的所有项目共享cookie信息
        c1.setPath("/");
        //3.发送cookie——服务器发送的(客户端一输入/cookieDemo1路径，服务器就通过response对象发送cookie给客户端
        response.addCookie(c1);
    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException{
        this.doPost(request, response);
    }

}
