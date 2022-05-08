package cn.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * @Author liming
 * @Date 2022/5/8 20:20
 **/
@WebServlet("/servletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {
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

        //2.��ȡ�ļ��ķ�������ʵ·��
        String realPath = context.getRealPath("/b.txt");  //webĿ¼����Դ����
        System.out.println(realPath);
        //File file = new File(realPath);
        String c = context.getRealPath("/WEB-INFO/c.txt");  //EWB-INFOĿ¼�µ���Դ����
        System.out.println(c);
        String a = context.getRealPath("/WEB-INFO/classes/a.txt");  //srcĿ¼�µ���Դ����
        System.out.println(a);
    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException{
       this.doPost(request,response);
    }
}
