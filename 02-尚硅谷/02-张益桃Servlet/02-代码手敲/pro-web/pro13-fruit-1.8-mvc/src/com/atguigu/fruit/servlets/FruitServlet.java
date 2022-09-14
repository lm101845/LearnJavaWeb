package com.atguigu.fruit.servlets;

import com.atguigu.fruit.dao.FruitDAO;
import com.atguigu.fruit.dao.impl.FruitDAOImpl;
import com.atguigu.fruit.pojo.Fruit;
import com.atguigu.myssm.myspringmvc.ViewBaseServlet;
import com.atguigu.myssm.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @Author liming
 * @Date 2022/9/14 19:13
 **/
@WebServlet("/fruit.do")
public class FruitServlet extends ViewBaseServlet {
    private FruitDAO fruitDAO = new FruitDAOImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("UTF-8");
        String operate = request.getParameter("operate");
        if (StringUtil.isEmpty(operate)) {
            operate = "index";
        }
        switch (operate) {
            case "index":
                index(request, response);
                break;
            case "add":
                add(request, response);
                break;
            case "del":
                del(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
            case "update":
                update(request, response);
                break;
            default:
                throw new RuntimeException("operate值非法！");
        }
    }

    //首页
    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        //先获取页码
        Integer pageNo = 1;
        String oper = request.getParameter("oper");
        //如果oper!=null，说明通过表单的查询按钮点击过来的
        //如果oper是空的，说明不是通过表单的查询按钮点击过来的
        //这样就可以区分了
        String keyword = null;

        if (StringUtil.isNotEmpty(oper) && "search".equals(oper)) {
            //说明是点击表单查询发送过来的请求
            //此时，pageNo应该还原为1，keyword应该从请求参数中获取
            pageNo = 1;
            keyword = request.getParameter("keyword");
            if (StringUtil.isEmpty(keyword)) {
                keyword = "";
            }
            session.setAttribute("keyword", keyword);
        } else {
            //说明此处不是点击表单查询发送过来的请求(比如点击下面的上一页、下一页，或者直接在地址栏输入网址)
            //此时keyword应该从session作用域中获取
            String pageNoStr = request.getParameter("pageNo");
            if (StringUtil.isNotEmpty(pageNoStr)) {
                pageNo = Integer.parseInt(pageNoStr);
                //如果从请求中读取到pageNo,则类型转换，否则，pageNo默认就是1
            }
            //如果不是点击的查询按钮，那么查询是基于session中保存的现有的keyword进行查询
            Object keywordObj = session.getAttribute(keyword);
            if (keywordObj != null) {
                keyword = (String) keywordObj;
            } else {
                keyword = "";
            }
        }

        session.setAttribute("pageNo", pageNo);
        //重新更新当前页的值

        FruitDAO fruitDAO = new FruitDAOImpl();
        List<Fruit> fruitList = fruitDAO.getFruitList(keyword, pageNo);
        Integer fruitCount = fruitDAO.getFruitCount(keyword);
        Integer pageCount = (fruitCount + 5 - 1) / 5;
        session.setAttribute("pageCount", pageCount);
        /**
         总记录条数       总页数
         1               1
         5               1
         6               2
         10              2
         11              3
         fruitCount      (fruitCount+5-1)/5
         */
        //保存到session作用域
        session.setAttribute("fruitList", fruitList);
        //此处的视图名称是 index
        //那么thymeleaf会将这个 逻辑视图名称 对应到 物理视图 名称上去
        //逻辑视图名称 ：   index
        //物理视图名称 ：   view-prefix + 逻辑视图名称 + view-suffix
        //所以真实的视图名称是：      /       index       .html
        super.processTemplate("index", request, response);
    }

    //添加
    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String fname = request.getParameter("fname");
        Integer price = Integer.parseInt(request.getParameter("price"));
        Integer fcount = Integer.parseInt(request.getParameter("fcount"));
        String remark = request.getParameter("remark");
        Fruit fruit = new Fruit(0, fname, price, fcount, remark);
        fruitDAO.addFruit(fruit);
        response.sendRedirect("fruit.do");
    }

    //删除
    private void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fidStr = request.getParameter("fid");
        if (StringUtil.isNotEmpty(fidStr)) {
            int fid = Integer.parseInt(fidStr);
            fruitDAO.delFruit(fid);
            response.sendRedirect("fruit.do");  //删除完后要继续再发一次请求，执行更新操作
        }
    }

    //编辑
    private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String fidStr = request.getParameter("fid");
        if (StringUtil.isNotEmpty(fidStr)) {
            int fid = Integer.parseInt(fidStr);
            Fruit fruit = fruitDAO.getFruitByFid(fid);
            request.setAttribute("fruit", fruit);
            super.processTemplate("edit", request, response);
        }
    }

    //更新
    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取参数
        String fidStr = request.getParameter("fid");
        int fid = Integer.parseInt(fidStr);
        String fname = request.getParameter("fname");
        String priceStr = request.getParameter("price");
        int price = Integer.parseInt(priceStr);
        String fcountStr = request.getParameter("fcount");
        Integer fcount = Integer.parseInt(fcountStr);
        String remark = request.getParameter("remark");
        //3.执行更新
        fruitDAO.updateFruit(new Fruit(fid, fname, price, fcount, remark));
        //4.资源跳转
//        super.processTemplate("index",request,response);
        //相当于request.getRequestDispatcher("index.html").forward(request.response)
        //跳的还是老的页面
        //应该跳到response.sendRedirect("index");
        //此处需要重定向，目的是重新给IndexServlet发请求，重新获取fruitlist，重新覆盖掉session，这样才是最新的
        response.sendRedirect("fruit.do");
    }
}
