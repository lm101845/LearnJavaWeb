package web.request;
/**
 * @Author liming
 * @Date 2022/4/16 23:05
 **/

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
@WebServlet("/requestDemo5")
public class RequestDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //只有POST请求才有请求体
        //获取请求消息体--请求参数

        //1.获取字符流
        BufferedReader br = request.getReader();
        //2.读取数据
        String line = null;
        while((line = br.readLine()) != null){
            System.out.println(line);
        }
        //这个流是通过request获取出来的，所以暂时不用关闭了
    }
}
