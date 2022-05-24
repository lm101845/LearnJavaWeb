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
//@WebFilter("/*")   //访问所有资源之前都会执行该过滤器
public class FilterDemo2 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filterDemo2被执行了...... ");
        //放行
        filterChain.doFilter(req,resp);
        //对response对象的响应消息增强
        System.out.println("filterDemo2回来了");
    }

    @Override
    public void destroy() {

    }
}

