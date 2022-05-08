package download; /**
 * @Author liming
 * @Date 2022/5/8 22:57
 **/

import utils.DownLoadUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downloadServlet")
public class DownLoadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.��ȡ�������,�ļ�����
        String filename = request.getParameter("filename");
        //ʹ���ֽ������������ļ����ڴ�
        //2.1 �ҵ��ļ�������·��
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);
        //2.2 ���ֽ�������
        FileInputStream fis = new FileInputStream(realPath);
        //3.����response����Ӧͷ
        //3.1 ������Ӧͷ����:content-type
        String mimeType = servletContext.getMimeType(filename);  //��ȡ�ļ���MIME����
        response.setHeader("content-type",mimeType);
        //3.2 ������Ӧͷ�򿪷�ʽ:content-disposition
        response.setHeader("content-disposition","attachment;filename=" + filename);
        //��������ļ�������
        //1.��ȡuser-agent����ͷ
        String agent = request.getHeader("user-agent");
        //2.ʹ�ù����෽���������ļ�������
        filename = DownLoadUtils.getFileName(agent,filename);
        //4.��������������д�����������
        ServletOutputStream  sos = response.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        while ((len = fis.read(buff)) != -1){
            sos.write(buff,0,len);
        }
        //�������ֽ���,����Ҳ����ˢ����
        fis.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
