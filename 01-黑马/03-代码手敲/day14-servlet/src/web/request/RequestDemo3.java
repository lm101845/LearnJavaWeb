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
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
