package cookie; /**
 * @Author liming
 * @Date 2022/5/9 13:47
 **/

/**
 在服务器中的Servlet判断是否有一个名为lastTime的cookie
 1. 有：不是第一次访问
 1. 响应数据：欢迎回来，您上次访问时间为:2018年6月10日11:50:20
 2. 写回Cookie：lastTime=2018年6月10日11:50:01
 2. 没有：是第一次访问
 1. 响应数据：您好，欢迎您首次访问
 2. 写回Cookie：lastTime=2018年6月10日11:50:01
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应的消息体的数据格式以及编码
        response.setContentType("text/html;charset=utf-8");
        //1.获取所有的cookie
        Cookie[] cookies = request.getCookies();
        boolean flag = false;  //没有cookie为lastTime
        //遍历cookie数组
        if(cookies != null && cookies.length > 0){
            for(Cookie cookie:cookies){
                //3.获取cookie的名称
                String name = cookie.getName();
                //4.判断名称是否是lastTime
                if("lastTime".equals(name)){
                    flag = true;   //有lastTime的cookie
                    //有：不是第一次访问
                    //设置cookie的value
                    //获取当前时间的字符串，重新设置cookie的值，重新发送cookie
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String str_date = sdf.format(date);
                    System.out.println("编码前：" + str_date);
                    //URL编码
                    URLEncoder.encode(str_date,"utf-8");
                    System.out.println("编码后：" + str_date);
                    cookie.setValue(str_date);
                    //在重新发送之前,设置cookie的存活时间为一个月
                    cookie.setMaxAge(60 * 60 * 24 * 30);
                    response.addCookie(cookie);
                    //把这个cookie给重新发送回去
                    //响应数据
                    //获取cookie的value,时间
                    String value = cookie.getValue();
                    //URL解码
                    System.out.println("解码前：" + value);
                    value = URLDecoder.decode(value,"utf-8");
                    System.out.println("解码后：" + value);
                    response.getWriter().write("<h1>欢迎回来，您上次访问时间为：" + value + "/<h1>");
                    break;
                }
            }
        }
        if(cookies == null || cookies.length == 0 || flag == false){
            //没有，第一次访问
            //设置cookie的value
            //获取当前时间的字符串，重新设置cookie的值，重新发送cookie
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String str_date = sdf.format(date);
            System.out.println("编码前："+str_date);
            //URL编码
            str_date = URLEncoder.encode(str_date,"utf-8");
            System.out.println("编码后："+str_date);
            Cookie cookie = new Cookie("lastTime",str_date);    //此时需要new一个cookie对象
            //在重新发送之前,设置cookie的存活时间为一个月
            cookie.setMaxAge(60 * 60 * 24 * 30);
            response.addCookie(cookie);
            response.getWriter().write("<h1>您好，欢迎您首次访问/<h1>");

        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
