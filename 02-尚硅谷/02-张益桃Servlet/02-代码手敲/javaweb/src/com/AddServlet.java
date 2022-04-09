package com;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author liming
 * @Date 2022/4/9 16:34
 **/
public class AddServlet extends HttpServlet {
    //HttpServlet是tomcat包里面的,所以要先引入tomcat依赖

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fname = request.getParameter("fname");
        String priceStr = request.getParameter("price");
        Integer price = Integer.parseInt(priceStr);
        String fcountStr = request.getParameter("fcount");
        Integer fcount = Integer.parseInt(fcountStr);
        String remark = request.getParameter("remark");

        System.out.println("fname" + fname);
        System.out.println("price" + price);
        System.out.println("account" + fcount);
        System.out.println("remark" + remark);
    }
}
