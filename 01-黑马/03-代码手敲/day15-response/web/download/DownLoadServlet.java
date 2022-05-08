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
        //1.获取请求参数,文件名称
        String filename = request.getParameter("filename");
        //使用字节输入流加载文件进内存
        //2.1 找到文件服务器路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);
        //2.2 用字节流关联
        FileInputStream fis = new FileInputStream(realPath);
        //3.设置response的响应头
        //3.1 设置响应头类型:content-type
        String mimeType = servletContext.getMimeType(filename);  //获取文件的MIME类型
        response.setHeader("content-type",mimeType);
        //3.2 设置响应头打开方式:content-disposition
        response.setHeader("content-disposition","attachment;filename=" + filename);
        //解决中文文件名问题
        //1.获取user-agent请求头
        String agent = request.getHeader("user-agent");
        //2.使用工具类方法来编码文件名即可
        filename = DownLoadUtils.getFileName(agent,filename);
        //4.将输入流的数据写出到输出流中
        ServletOutputStream  sos = response.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        while ((len = fis.read(buff)) != -1){
            sos.write(buff,0,len);
        }
        //由于是字节流,我们也不用刷新了
        fis.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
