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
            ServletContext功能：
               1. 获取MIME类型：
                * MIME类型:在互联网通信过程中定义的一种文件数据类型
                    * 格式： 大类型/小类型   text/html		image/jpeg

                * 获取：String getMimeType(String file)
                2. 域对象：共享数据
                3. 获取文件的真实(服务器)路径
         */
        //1.通过HttpServlet获取
        ServletContext context = this.getServletContext();

        //2.获取文件的服务器真实路径
        String realPath = context.getRealPath("/b.txt");  //web目录下资源访问
        System.out.println(realPath);
        //File file = new File(realPath);
        String c = context.getRealPath("/WEB-INFO/c.txt");  //EWB-INFO目录下的资源访问
        System.out.println(c);
        String a = context.getRealPath("/WEB-INFO/classes/a.txt");  //src目录下的资源访问
        System.out.println(a);
    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException{
       this.doPost(request,response);
    }
}
