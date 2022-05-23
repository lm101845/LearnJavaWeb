package web.servlet;
/**
 * @Author liming
 * @Date 2022/5/22 22:20
 **/

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.���ñ���
        request.setCharacterEncoding("utf-8"); 
        //2.��ȡ����
        //2.1 ��ȡ�û���д����֤��
        String verifycode = request.getParameter("verifycode");

        //3.��֤��У��
        HttpSession session = request.getSession();
        String checkcode_server = (String)session.getAttribute("CHECKCODE_SERVER");
        //��֤��Ҫ��һ���Ե�
        session.removeAttribute("CHECKCODE_SERVER");   //ȷ����֤����һ���Ե�
        if(!checkcode_server.equalsIgnoreCase(verifycode)){
            //��֤�벻��ȷ
            //��ʾ��Ϣ
            //request.setAttribute("login_msg","��֤�����");
            request.setAttribute("login_msg","Check Code is Wrong");
            //��ת��¼ҳ��
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
        Map<String, String[]> map = request.getParameterMap();
        //4.��װUser����
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //5.����Service��ѯ
        UserServiceImpl service = new UserServiceImpl();
        User loginUser = service.login(user);
        //6.�ж��Ƿ��¼�ɹ�
        if(loginUser != null){
            //��¼�ɹ�
            //���û�����session
            session.setAttribute("user",loginUser);
            //��תҳ��
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }else{
            //��¼ʧ��
            //��ʾ��Ϣ
            //request.setAttribute("login_msg","�û������������");
            request.setAttribute("login_msg","User or Password is Wrong");
            //��ת��¼ҳ��
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
