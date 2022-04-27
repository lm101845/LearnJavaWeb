package cn.web;


import cn.dao.UserDao;
import cn.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
/**
 * @Author liming
 * @Date 2022/4/27 13:00
 **/
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.���ñ���
        req.setCharacterEncoding("utf-8");
        //����1��
//        //2.��ȡ�������
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        //3.��װuser����
//        User loginUser = new User();
//        loginUser.setUsername(username);
//        loginUser.setPassword(password);

        //����2��ʹ��Bean�����з�װ
        //2.��ȡ�����������
        Map<String, String[]> map = req.getParameterMap();

        //3.����User����
        User loginUser = new User();
        //3.2ʹ��BeanUtils��װ
        try {
            BeanUtils.populate(loginUser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //4.����UserDao��login����
        UserDao dao = new UserDao();
        User user = dao.login(loginUser);
        //5.�ж�user
        if(user == null){
            //��¼ʧ��
            req.getRequestDispatcher("/failServlet").forward(req,resp);
        }else {
            //��¼�ɹ�
            //�洢����
            req.setAttribute("user",user);
            req.getRequestDispatcher("/successServlet").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
