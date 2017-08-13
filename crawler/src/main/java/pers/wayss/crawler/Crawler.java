package pers.wayss.crawler;

import java.util.Set;

public class Crawler {
    
    //抓取网站的URL前缀
//    private static final String URL_PATH = "http://www.douban.com/group/haixiuzu/discussion?start=0";
//    private static final String URL_PRE = "douban.com/group/topic";
    
    private static final String URL_PATH = "http://blog.sina.com.cn/s/blog_4de3b15e0102wixu.html";

    /**
     * 抓取过程
     * 
     * @return
     * @param seeds
     */
    public void crawling(String url) { // 定义过滤器
        
        Filter filter = new Filter() {
            public boolean accept(String url) {
                return true;
                /*
                //这里过滤规则随需要爬的网站的规则进行改变，推荐使用正则实现，本人是爬豆瓣网站
                if(url.indexOf(URL_PRE) != -1)
                    return true;
                else
                    return false;*/
            }
        };
        // 初始化 URL 队列
        LinkQueue.addUnvisitedUrl(url);
        
        // 循环条件，待抓取的链接不空
        while (!LinkQueue.unVisitedUrlsEmpty()) {
            // 队头URL出队列
            String visitUrl = (String) LinkQueue.unVisitedUrlDeQueue();
            if (visitUrl == null)
                continue;
            
            DownLoadPic.downloadPic(visitUrl);

            // 提取出下载网页中的 URL
            Set<String> links = ParserHttpUrl.extracLinks(visitUrl, filter);
            // 新的未访问的 URL 入队
            for (String link : links) {
                LinkQueue.addUnvisitedUrl(link);
            }
        }
    }

    // main 方法入口
    public static void main(String[] args) {
        Crawler crawler = new Crawler();
        crawler.crawling(URL_PATH);
    }
}
