package jsoup;

/**
 * @author ����
 * @date 2021��07��05�� 23:47
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Document����
 */
public class JsoupDemo03 {
    public static void main(String[] args) throws IOException {
        //2.��ȡDocument���󣬸���xml�ĵ���ȡ
        //2.1��ȡstudent.xml��path
        String path = JsoupDemo03.class.getClassLoader().getResource("D:\\02-looking for job\\00-Project\\44-LearnJavaWeb\\LearnJavaWeb\\01-����\\02-��������\\day12-XML\\src\\jsoup\\student2.xml").getPath();
        //2.��ȡDocument����
        Document document = Jsoup.parse(new File(path),"utf-8");

        //3.��ȡԪ�ض���
        //3.1��ȡ����student����
        Elements element = document.getElementsByTag("student");
        System.out.println(element);
        System.out.println("=================");

        //3.2 ��ȡ������Ϊid��Ԫ�ض�����
        Elements elements2 = document.getElementsByAttributeValue("number", "heima_0001");
        System.out.println(elements2);
        System.out.println("==============");

        //3.3��ȡid����ֵ��Ԫ�ض���
        Element itcast = document.getElementById("itcast");
        System.out.println(itcast);
    }
}
