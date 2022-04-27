package cn.web; /**
 * @Author liming
 * @Date 2022/4/27 13:49
 **/

import cn.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/successServlet")
public class SuccessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //��ȡrequest���й����user����
        User user = (User)request.getAttribute("user");
        if(user != null){
            //��ҳ��дһ�仰
            //���ñ���
            response.setContentType("text/html;charset=utf-8");
            //���
            response.getWriter().write("��¼�ɹ�," + user.getUsername() + ",��ӭ��");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
