package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author liming
 * @Date 2022/5/9 12:59
 **/
@WebServlet("/cookieDemo")
public class CookieDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        //��ȡcookie��Ϣ
        //Request��������á�����ȡ������Ϣ
        System.out.println("test��Ŀxxx");
        Cookie[] cs = request.getCookies();
        //4.��ȡ���ݣ�����Cookies
        if(cs != null){
            for(Cookie c:cs){
                String name = c.getName();
                String value = c.getValue();
                System.out.println(name + ":" + value);
                //�ڲ���ʹ��map�Ľṹ���洢���ݵ�
            }
        }
    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException{
        this.doPost(request, response);
    }
}
