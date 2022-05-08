package cn.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author liming
 * @Date 2022/5/8 20:20
 **/
@WebServlet("/servletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        /**
            ServletContext�����ȡ��
                1. ͨ��request�����ȡ
			        request.getServletContext();
                2. ͨ��HttpServlet��ȡ
                    this.getServletContext();
         */
        //1.ͨ��request�����ȡ
        ServletContext context1 = request.getServletContext();
        //2.ͨ��HttpServlet��ȡ
        ServletContext context2 = this.getServletContext();
        System.out.println(context1);   //org.apache.catalina.core.ApplicationContextFacade@1971ea25
        System.out.println(context2);   //org.apache.catalina.core.ApplicationContextFacade@1971ea25
        System.out.println(context1 == context2);  //true
    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException{
       this.doPost(request,response);
    }
}
