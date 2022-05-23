package web.servlet;
/**
 * @Author liming
 * @Date 2022/5/23 21:04
 **/

import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/delSelectedServlet")
public class DelSelectedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取所有的Id
        String[] ids = request.getParameterValues("uid");
        //2.调用service删除
        UserService service = new UserServiceImpl();
        service.delSelectedUser(ids);
        //3.跳转到查询所有Servlet
        response.sendRedirect(request.getContextPath() + "/userListServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
