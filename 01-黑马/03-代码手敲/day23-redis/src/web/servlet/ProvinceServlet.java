package web.servlet;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Province;
import service.ProvinceService;
import service.impl.ProvinceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author liming
 * @Date 2022/5/26 16:15
 **/
@WebServlet("/provinceServlet")
public class ProvinceServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       //1.����service��ѯ
//        ProvinceService service = new ProvinceServiceImpl();
//        List<Province> list = service.findAll();
//        //2.���л�listΪjson
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(list);

        //1.����service��ѯ
        ProvinceService service = new ProvinceServiceImpl();
        String json = service.findAllJson();


        System.out.println(json);
        //3.��Ӧ���
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
