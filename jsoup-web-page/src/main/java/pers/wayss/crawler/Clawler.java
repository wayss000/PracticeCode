package pers.wayss.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * @author Wayss.
 * @date 2019/7/2.
 */
public class Clawler {

    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://blog.csdn.net/qq1332479771")
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36")
                    .timeout(3000).get();
            Elements elements1 = doc.select("ul.archive-list a");
            System.out.println(elements1.size());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
