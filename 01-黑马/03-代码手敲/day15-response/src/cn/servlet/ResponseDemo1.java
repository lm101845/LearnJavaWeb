package cn.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author liming
 * @Date 2022/5/8 12:44
 **/

/**
 * 重定向
 */
@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo1被访问了xxxx");
        //方法1：
        //访问/responseDemo1，会自动跳转到/responseDemo2资源
//        // 1. 设置状态码为302
//        response.setStatus(302);
//        //2.设置响应头location
//        response.setHeader("location","/day15/responseDemo2");

        //动态获取虚拟目录
        String contextPath = request.getContextPath();
        //方法2：简单的重定向方法——这个方法实现的原理就是方法1
        request.setAttribute("msg","你好啊");
        //response.sendRedirect("/day15/responseDemo2");
        response.sendRedirect(contextPath + "/responseDemo2");  //写成动态的更好
        //response.sendRedirect("http://www.baidu.com");


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
