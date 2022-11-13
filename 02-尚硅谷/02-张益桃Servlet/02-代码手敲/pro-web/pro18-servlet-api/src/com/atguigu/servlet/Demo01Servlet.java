package com.atguigu.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author liming
 * @Date 2022/11/13 8:25
 **/
//@WebServlet(urlPatterns = {"/demo01"},initParams = {
//        @WebInitParam(name="hello",value="world"),
//        @WebInitParam(name="uname",value="jim")
//})
public class Demo01Servlet extends HttpServlet {
    //Servlet生命周期：实例化、初始化、服务、销毁

    @Override
    public void init() throws ServletException {
        ServletConfig config = getServletConfig();
        System.out.println(config);
        String initValue = config.getInitParameter("hello");
        //获取初始化参数，可以在xml中配置
        System.out.println(initValue);
        ServletContext servletContext = getServletContext();
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
        System.out.println(contextConfigLocation + "--contextConfigLocation");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.getServletContext();
        req.getSession().getServletContext();
    }
}
