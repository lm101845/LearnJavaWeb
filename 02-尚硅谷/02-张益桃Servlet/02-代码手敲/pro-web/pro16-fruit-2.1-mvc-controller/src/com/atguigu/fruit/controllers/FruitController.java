package com.atguigu.fruit.controllers;
import com.atguigu.fruit.dao.FruitDAO;
import com.atguigu.fruit.dao.impl.FruitDAOImpl;
import com.atguigu.fruit.pojo.Fruit;
import com.atguigu.myssm.util.StringUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author liming
 * @Date 2022/9/14 19:13
 **/

public class FruitController{

    private FruitDAO fruitDAO = new FruitDAOImpl();
    //首页
    private String index(String oper,String keyword,Integer pageNo,HttpServletRequest request){

        HttpSession session = request.getSession();
        if(pageNo == null){
            pageNo = 1;
        }
        if (StringUtil.isNotEmpty(oper) && "search".equals(oper)) {
            pageNo = 1;
            if (StringUtil.isEmpty(keyword)) {
                keyword = "";
            }
            session.setAttribute("keyword", keyword);
        } else {
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
        session.setAttribute("fruitList", fruitList);

        Integer fruitCount = fruitDAO.getFruitCount(keyword);
        Integer pageCount = (fruitCount + 5 - 1) / 5;
        session.setAttribute("pageCount", pageCount);

        return "index";
    }

    //添加
    private String add(String fname,Integer price,Integer fcount,String remark){
        Fruit fruit = new Fruit(0, fname, price, fcount, remark);
        fruitDAO.addFruit(fruit);
        //response.sendRedirect("fruit.do");
        return "redirect:fruit.do";
    }

    //删除
    private String del(Integer fid){
        if (fid != null) {
            fruitDAO.delFruit(fid);
            //response.sendRedirect("fruit.do");  //删除完后要继续再发一次请求，执行更新操作
            return "redirect:fruit.do";
        }
        return "error";
    }

    //编辑
    private String edit(Integer fid,HttpServletRequest request){
        if (fid != null) {
            Fruit fruit = fruitDAO.getFruitByFid(fid);
            request.setAttribute("fruit", fruit);
            //super.processTemplate("edit", request, response);
            return "edit";
        }
        return "error";
    }

    //更新
    private String update(Integer fid,String fname,Integer price,Integer fcount,String remark){
        //3.执行更新
        fruitDAO.updateFruit(new Fruit(fid, fname, price, fcount, remark));
        //4.资源跳转
        //response.sendRedirect("fruit.do");
        return "redirect:fruit.do";
    }
}
