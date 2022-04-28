package web.servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @Author liming
 * @Date 2022/4/28 23:09
 **/
@WebServlet("/servletDemo1")
public class ServletDemo1 extends HttpServlet{
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException{

    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException{
        int i = 3 / 0;   //这个肯定会报错，这个就是5xx错误，服务器内部出错
    }
}
