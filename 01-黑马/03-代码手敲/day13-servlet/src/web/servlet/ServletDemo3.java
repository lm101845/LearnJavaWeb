package web.servlet;

/**
 * @Author liming
 * @Date 2022/4/16 21:35
 **/

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * servlet快速入门
 * */
@WebServlet(urlPatterns = "/demo3")
public class ServletDemo3 implements Servlet {
    /**
     * 初始化方法
     * 在servlet被创建时，执行，且只执行一次
     * */

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init3......");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务的方法
     * 每一次Servlet被访问时，执行，且执行多次
     * */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service3...... ");
    }

    /**
     * 获取servlet的一些信息，版本，作者等等
     * */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁方法
     * 在服务器正常被关闭时，执行，且执行一次
     * */
    @Override
    public void destroy() {
        System.out.println("destroy3...");
    }
}
