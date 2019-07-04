package pers.wayss.crawler.thread;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author Wayss.
 * @date 2019/7/2.
 */
public class CrawlerAllPage {

    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36";

    private static final String CSDN_NET = "https://blog.csdn.net/";
    //你的CSDNID
    private static final String CSDN_ID = "qq1332479771";
    //你的CSDN博客
    private static String CSDN_URL = CSDN_NET + CSDN_ID;

    /**
     * 分页URL中间部分，人工通过观察获得
     */
    private static final String SEPARATE = "/article/list/";

    /**
     * 总页数，人工通过页面观察获得
     */
    private static final int TOTAL_PAGE = 13;

    /**
     * key:博客的url
     * value:博客的访问量
     */
    private ConcurrentHashMap<String, Integer> pageCountRelation = new ConcurrentHashMap(16);

    public ConcurrentHashMap<String, Integer> getAllPageUrl() {

        try {
            System.out.println("遍历所有分页查询博客具体URL...");
            //1.遍历每一页，获取所有博客的url
            for (int i = 1; i <= TOTAL_PAGE; i++) {
                String pageUrl = CSDN_URL + SEPARATE + i;
                Document doc = Jsoup.connect(pageUrl)
                        .userAgent(USER_AGENT)
                        .timeout(10000).get();

                Elements blogs = doc.select("h4 a[href*=\"" + CSDN_ID + "\"]");
                for (Element blog : blogs) {
                    String blogUrl = blog.attributes().get("href");
                    pageCountRelation.put(blogUrl, 0);
                }
                //提交线程不能太快，否则会报HTTP 544异常，怀疑是CSDN防刷措施
                TimeUnit.SECONDS.sleep(2);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("查询博客具体URL完成!");
        return pageCountRelation;
    }

}
