package cn.web; /**
 * @Author liming
 * @Date 2022/4/27 13:49
 **/

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/failServlet")
public class FailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //��ҳ��дһ�仰
        //���ñ���
        response.setContentType("text/html;charset=utf-8");
        //���
        response.getWriter().write("��¼ʧ�ܣ��û������������");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
