package pers.wayss.crawler;

import com.alibaba.fastjson.JSON;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * @author Wayss.
 * @date 2019/7/2.
 */
public class Clawler {

    public static void main(String[] args) {
        try {
            Document document = Jsoup.connect("https://blog.csdn.net/qq1332479771").get();
            System.out.println(JSON.toJSONString(document.title()));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
