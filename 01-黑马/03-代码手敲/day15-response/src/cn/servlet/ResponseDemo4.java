package cn.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author liming
 * @Date 2022/5/8 12:44
 **/
@WebServlet("/responseDemo4")
public class ResponseDemo4 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取流对象之前，设置流的默认编码:ISO-8859-1，改成GBK,或者UTF-8
        //并且告诉浏览器，服务器发送的消息体数据的编码，并建议浏览器使用该编码解码
        //response.setCharacterEncoding("utf-8");  //其实这个你可以不写，只写setHeader那句也是可以的
        //这句话告诉浏览器，我使用的是UTF-8编码的，建议你也使用UTF-8进行解码
        //浏览器很听话的，它读到了这个响应头，是一定会用utf-8进行解码的,这个是在http协议里面规定好的事情
        //response.setHeader("content-type","text/html;charset=utf-8");

        //简单形式设置编码：注意：要在获取流之前就要设置了
        response.setContentType("text/html;charset=utf-8");
        //1.获取字符输出流
        PrintWriter pw = response.getWriter();
        //拿到流（可以理解为管道）对象，而非response这个实体，他拿到了PrintWriter这个类的字符流对象，然后对流进行操作
        //2.输出数据
        pw.write("<h1>hello response,你好</h1>");
        pw.write("<h2>你好,这个会乱码，原因：编解码不一致</h2>");
        //浏览器用的GB2312,服务器用的ISO-8859-1
        //这个就是响应的消息体
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
