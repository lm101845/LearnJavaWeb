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
 * Jsoup��������
 */
public class JsoupDemo01 {
    public static void main(String[] args) throws IOException {
        //2.��ȡDocument���󣬸���xml�ĵ���ȡ
        //2.1��ȡstudent.xml��path
        String path = JsoupDemo01.class.getClassLoader().getResource("D:\\02-looking for job\\00-Project\\44-LearnJavaWeb\\LearnJavaWeb\\01-����\\02-��������\\day12-XML\\src\\jsoup\\student.xml").getPath();
        //2.2����xml�ĵ��������ĵ����ڴ棬��ȡdom��--->Document
        Document document = Jsoup.parse(new File(path),"utf-8");
        //3.��ȡԪ�ض��� Element
        Elements elements = document.getElementsByTag("name");
        System.out.println(elements.size());
        //3.1��ȡ��һ��name��Element����
        Element element = elements.get(0);
        //3.2��ȡ����
        String name = element.text();
        System.out.println(name);
    }
}
