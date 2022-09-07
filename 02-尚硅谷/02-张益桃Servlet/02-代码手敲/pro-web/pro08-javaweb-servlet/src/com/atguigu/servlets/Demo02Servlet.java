package com.atguigu.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author liming
 * @Date 2022/9/7 8:38
 **/
//演示Servlet的生命周期
public class Demo02Servlet extends HttpServlet {
    public Demo02Servlet(){
        System.out.println("正在实例化...");
    }
    @Override
    public void init() throws ServletException {
        System.out.println("正在初始化......");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //在service方法内部，它会细分，这是get请求，post请求或者其他请求
        System.out.println("正在服务......");
    }

    @Override
    public void destroy() {
        System.out.println("正在销毁......");
    }
}
