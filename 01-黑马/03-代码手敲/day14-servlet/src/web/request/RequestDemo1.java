package web.request; /**
 * @Author liming
 * @Date 2022/4/16 23:05
 **/

import jdk.swing.interop.SwingInterOpUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 演示Request对象获取请求行数据
 */

/**
    1. 获取请求方式 ：GET
        * String getMethod()
    2. (*)获取虚拟目录：/day14
        * String getContextPath()
    3. 获取Servlet路径: /requestDemo1
        * String getServletPath()
    4. 获取get方式请求参数：name=zhangsan
        * String getQueryString()
    5. (*)获取请求URI：/day14/demo1
        * String getRequestURI():		/day14/requestDemo1
        * StringBuffer getRequestURL()  :http://localhost/day14/requestDemo1
    6. 获取协议及版本：HTTP/1.1
        * String getProtocol()

    7. 获取客户机的IP地址：
        * String getRemoteAddr()

 */

@WebServlet("/requestDemo1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求方式:GET
        String method = request.getMethod();
        System.out.println(method);

        //2.获取虚拟目录(重要):/day13
        String contextPath = request.getContextPath();
        System.out.println(contextPath);

        //3.获取Servlet路径: /requestDemo1
        String servletPath = request.getServletPath();
        System.out.println(servletPath);

        //4.获取get方式请求参数：name=zhangsan
        String queryString = request.getQueryString();
        System.out.println(queryString);

        //5.获取请求URI：/day13/demo1
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURL);

        //6.获取协议及版本：HTTP/1.1
        String protocol = request.getProtocol();
        System.out.println(protocol);

        //7.获取客户机的IP地址：
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
