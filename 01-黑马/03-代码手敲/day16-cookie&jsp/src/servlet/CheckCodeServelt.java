package servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @Author liming
 * @Date 2022/5/8 12:44
 **/
@WebServlet("/checkCodeServlet")
public class CheckCodeServelt extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建一个对象，在内存中画图(验证码图片对象)
        int width = 100;
        int height = 50;
        BufferedImage image =  new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //2.美化图片
        //2.1 填充背景色
        Graphics g = image.getGraphics();
        g.setColor(Color.PINK);
        g.fillRect(0,0,width,height);
        //2.2画边框
        g.setColor(Color.BLUE);
        g.drawRect(0,0,width-1,height-1);
        //因为边框本身有1像素的大小
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";
        Random ran = new Random();
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= 4;i++){
            //生成随机角标
            int index = ran.nextInt(str.length());
            //获取字符
            char ch = str.charAt(index); //随机字符
            //每生成一个字符，使用sb.append把字符放进来
            sb.append(ch);
            //2.3 写验证码
            g.drawString(ch + "",width / 5 * i,height / 2);
        }
        String checkCode_session = sb.toString();
        //将验证码存入session
        request.getSession().setAttribute("checkCode_session",checkCode_session);
        //2.4画干扰线
        g.setColor(Color.GREEN);
        //随机生成坐标点(x1,y1,x2,y24个值都是随机的)
        //画10条线
        for (int i = 0; i < 10; i++) {
            int x1 = ran.nextInt(width);
            int x2 = ran.nextInt(width);
            int y1 = ran.nextInt(height);
            int y2 = ran.nextInt(height);
            //给定一个参数n，nextInt(n)将返回一个大于等于0小于n的随机数
            g.drawLine(x1,y1,x2,y2);
        }


        //3.将图片输出到页面展示
        ImageIO.write(image,"jpg",response.getOutputStream());
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
