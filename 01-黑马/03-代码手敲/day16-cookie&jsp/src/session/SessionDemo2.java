package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author liming
 * @Date 2022/5/10 14:32
 **/
@WebServlet("/sessionDemo2")
public class SessionDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        //使用session来获取数据
        //1.获取session
        HttpSession session = request.getSession();
        //2.存储数据
        Object msg = session.getAttribute("msg");
        System.out.println(msg);
        //在【一次会话】中，才能共享数据，使用另一个浏览器打开，是拿不到的了
    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException{
        this.doPost(request, response);
    }
}
