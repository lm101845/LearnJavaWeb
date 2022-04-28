package web.request;
/**
 * @Author liming
 * @Date 2022/4/16 23:05
 **/

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestDemo8")
public class RequestDemo8 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo888被访问了");
        //转发到demo9资源
        /**
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("requestDemo9");
        requestDispatcher.forward(request,response);
         */

        //存储数据到request域中
        request.setAttribute("msg","hello");

        //链式编程写法
        //request.getRequestDispatcher("www.baidu.com").forward(request,response);
        request.getRequestDispatcher("/requestDemo9").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
