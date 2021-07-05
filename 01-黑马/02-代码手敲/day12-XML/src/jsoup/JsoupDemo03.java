package jsoup;

/**
 * @author 李明
 * @date 2021年07月05日 23:47
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Document对象
 */
public class JsoupDemo03 {
    public static void main(String[] args) throws IOException {
        //2.获取Document对象，根据xml文档获取
        //2.1获取student.xml的path
        String path = JsoupDemo03.class.getClassLoader().getResource("D:\\02-looking for job\\00-Project\\44-LearnJavaWeb\\LearnJavaWeb\\01-黑马\\02-代码手敲\\day12-XML\\src\\jsoup\\student2.xml").getPath();
        //2.获取Document对象
        Document document = Jsoup.parse(new File(path),"utf-8");

        //3.获取元素对象
        //3.1获取所有student对象
        Elements element = document.getElementsByTag("student");
        System.out.println(element);
        System.out.println("=================");

        //3.2 获取属性名为id的元素对象们
        Elements elements2 = document.getElementsByAttributeValue("number", "heima_0001");
        System.out.println(elements2);
        System.out.println("==============");

        //3.3获取id属性值的元素对象
        Element itcast = document.getElementById("itcast");
        System.out.println(itcast);
    }
}
