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
@WebServlet("/servletContextDemo3")
public class ServletContextDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        /**
            ServletContext���ܣ�
               1. ��ȡMIME���ͣ�
                * MIME����:�ڻ�����ͨ�Ź����ж����һ���ļ���������
                    * ��ʽ�� ������/С����   text/html		image/jpeg

                * ��ȡ��String getMimeType(String file)
                2. ����󣺹�������
                3. ��ȡ�ļ�����ʵ(������)·��
         */
        //1.ͨ��HttpServlet��ȡ
        ServletContext context = this.getServletContext();

        //2.��������
        context.setAttribute("msg", "haha");
    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException{
       this.doPost(request,response);
    }
}
