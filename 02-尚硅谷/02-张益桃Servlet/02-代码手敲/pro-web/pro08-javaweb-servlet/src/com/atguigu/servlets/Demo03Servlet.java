package com.atguigu.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author liming
 * @Date 2022/9/7 9:48
 **/

//演示session
public class Demo03Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取session,如果获取不到，则创建一个新的
        HttpSession session = req.getSession();
        System.out.println("服务端获取到的session为：(没获取到则创建一个 )" + session.getId());
    }
}
