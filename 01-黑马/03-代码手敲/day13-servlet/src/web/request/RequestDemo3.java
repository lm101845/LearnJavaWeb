package web.request; /**
 * @Author liming
 * @Date 2022/4/16 23:05
 **/

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 演示获取请求头数据:
 *      user-agent(用户代理)——用来告诉服务器客户端的版本
 *      referer——告诉浏览器请求从哪里来
 */

@WebServlet("/requestDemo3")
public class RequestDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String agent = request.getHeader("user-agent");
        if(agent.contains("Chrome")){
            System.out.println("这个是谷歌浏览器访问的");
        }else if(agent.contains("Firefox")){
            System.out.println("这个是火狐浏览器访问的");
        }
        System.out.println("agent为：" + agent);

        String referer = request.getHeader("referer");
        System.out.println("referer为：" + referer);
        //refererhttp://localhost:8080/day13/login.html

        //可以通过referer实现防盗链操作
        if(referer != null){
            if(referer.contains("/day13")){
                //正常访问
                //System.out.println("正常访问，播放电影");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("正常播放电影......");
            }else{
                //盗链
                //System.out.println("想看电影吗？来优酷吧...");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("你这个是盗链啊，想看电影的话去优酷吧......");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
