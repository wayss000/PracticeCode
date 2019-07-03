package pers.wayss.crawler.thread;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Wayss.
 * @date 2019/7/2.
 */
public class CrawlerMultipleThread {

    private static final String USERAGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36";

    private static final String CSDNURL = "https://blog.csdn.net/qq1332479771";

    /**
     * 分页URL中间部分，人工通过观察获得
     */
    private static final String SEPARATE = "/article/list/";

    /**
     * 总页数，人工通过页面观察获得
     */
    private static final int TOTALPAGE = 13;

    /**
     * key:博客的url
     * value:博客的访问量
     */
    private Map<String, Integer> pageCountRelation = new HashMap(16);

    public void crawlWebPage() {

        try {

            //1.遍历每一页，获取每篇博客的url和访问量
            for (int i = 1; i <= TOTALPAGE; i++) {
                String pageUrl = CSDNURL + SEPARATE + i;
                Document doc = Jsoup.connect(pageUrl)
                        .userAgent(USERAGENT)
                        .timeout(10000).get();

                Elements blogs = doc.select("h4 a[href*=\"qq1332479771\"]");
                for (Element blog : blogs) {
                    String blogUrl = blog.attributes().get("href");
                    pageCountRelation.put(blogUrl, 0);
                }
            }

            //2.遍历所有博客，获取博客的访问量
            viewPage();

            //3.pageCountRelation循环，直到pageCountRelation为空停止
            while (pageCountRelation.size() > 0){
                for (String blogUrl : pageCountRelation.keySet()) {
                    Integer count = pageCountRelation.get(blogUrl);
                    //访问量大于条件值时，不刷了
                    if (count > 30){
                        break;
                    }
                    //TODO 同IP，60秒内重复访问算一次有效阅读
                    viewPage();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void viewPage() throws IOException {
        for (String blogUrl : pageCountRelation.keySet()) {
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

            Integer count = Integer.valueOf(countStr);
            pageCountRelation.put(blogUrl, count);
            System.out.println(blogDetail.title() + "访问量=" + countStr);
        }
    }
}
