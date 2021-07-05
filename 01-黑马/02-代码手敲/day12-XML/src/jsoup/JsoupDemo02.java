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
import java.net.URL;

/**
 * Jsoup������
 */
public class JsoupDemo02 {
    public static void main(String[] args) throws IOException {
        //2.��ȡDocument���󣬸���xml�ĵ���ȡ
        //2.1��ȡstudent.xml��path
        String path = JsoupDemo02.class.getClassLoader().getResource("D:\\02-looking for job\\00-Project\\44-LearnJavaWeb\\LearnJavaWeb\\01-����\\02-��������\\day12-XML\\src\\jsoup\\student.xml").getPath();
        //2.2����xml�ĵ��������ĵ����ڴ棬��ȡdom��--->Document
          //Document document = Jsoup.parse(new File(path),"utf-8");
//        System.out.println(document);

        //2.parse(String html)������xml��html�ַ���
//        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
//                "\n" +
//                "<students>\n" +
//                "\t<student number=\"heima_0001\">\n" +
//                "\t\t<name>tom</name>\n" +
//                "\t\t<age>18</age>\n" +
//                "\t\t<sex>male</sex>\n" +
//                "\t</student>\n" +
//                "\t<student number=\"heima_0002\">\n" +
//                "\t\t<name>jack</name>\n" +
//                "\t\t<age>18</age>\n" +
//                "\t\t<sex>female</sex>\n" +
//                "\t</student>\n" +
//                "\n" +
//                "</students>";
//        Jsoup.parse(str);
//        System.out.println(document);

        //3.parse(URL url, int timeoutMillis)��ͨ������·����ȡָ����html��xml���ĵ�����
        URL url = new URL("https://baike.baidu.com/item/jsoup/9012509?fr=aladdin");//���������е�һ����Դ·��
        Document document = Jsoup.parse(url, 10000);
        System.out.println(document);
    }
}
