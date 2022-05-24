package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author liming
 * @Date 2022/5/24 7:51
 **/

/**
 * 过滤器的快速入门程序
 */
@WebFilter("/*")   //访问所有资源之前都会执行该过滤器
public class FilterDemo3 implements Filter {
    //在服务器启动后，会创建Filter对象，然后调用init方法，只执行一次，用于加载资源
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("initxxx");
    }

    /**
     *可执行多次
     * @param req
     * @param resp
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter...... ");
        //放行
        chain.doFilter(req,resp);
    }

    /**
     * 在服务器被关闭后，Filter对象被销毁，如果服务器被正常关闭，则会执行destrory方法，用于释放资源
     */
    @Override
    public void destroy() {
        System.out.println("destroyxxx");
    }
}

