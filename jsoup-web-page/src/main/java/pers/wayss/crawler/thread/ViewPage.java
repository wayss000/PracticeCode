package pers.wayss.crawler.thread;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * 职责：访问url，并更新阅读数量
 *
 * @author Wayss.
 * @date 2019/7/4.
 */
public class ViewPage implements Runnable {

    private static final String USERAGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36";

    //博客url和访问量的关系
    private ConcurrentHashMap<String, Integer> pageCountRelation;

    //博客url
    private String blogUrl;

    //最大的阅读量，大于此阅读量的博客就不访问了
    private static final int MAX_COUNT = 30;

    private static final int WAIT_SECOND_TIME = 61;

    public ViewPage(ConcurrentHashMap map, String blogUrl) {
        this.pageCountRelation = map;
        this.blogUrl = blogUrl;
    }

    public void run() {

        try {
            //同IP，60秒内重复访问算一次有效阅读
            viewPage(blogUrl);
            TimeUnit.SECONDS.sleep(WAIT_SECOND_TIME);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Integer count = pageCountRelation.get(blogUrl);
        //访问量大于条件值时，不刷了，并从map中移除对应url
        if (count > MAX_COUNT) {
            pageCountRelation.remove(blogUrl);
            return;
        }
    }

    private void viewPage(String blogUrl) throws IOException {
        Document blogDetail = Jsoup.connect(blogUrl)
                .userAgent(USERAGENT)
                .timeout(10000).get();
        //获取阅读数的元素
        Elements elements = blogDetail.select(".read-count");
        Element element = elements.get(0);
        String temp = element.toString();
        //正则获取阅读数
        String regex = ".+阅读数 (\\d+)</span>";
        String countStr = temp.replaceAll(regex, "$1");
        //将最新的阅读数更新到对应博客
        Integer count = Integer.valueOf(countStr);
        pageCountRelation.put(blogUrl, count);
        System.out.println(blogDetail.title() + "访问量=" + countStr);
    }

}
