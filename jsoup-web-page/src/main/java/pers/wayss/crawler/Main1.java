package pers.wayss.crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * java爬取csdn博客的简单的案例，如果你只爬取某个博主的首页文章，那么参考本程序员
 * 如果你想爬取某位博主的所有文章，请参考Main.java
 * @author shizongger
 * @date 2017/02/09
 */
public class Main1 {
	
	//需要进行爬取得博客首页
//	private static final String URL = "http://blog.csdn.net/guolin_blog";
	private static final String URL = "http://blog.csdn.net/sinyu890807/article/list/2";
	
	public static void main(String[] args) throws IOException {
		
		//获取url地址的http链接Connection
        Connection conn = Jsoup.connect(URL)	//博客首页的url地址
                .userAgent("Mozilla/5.0 (Windows NT 6.1; rv:47.0) Gecko/20100101 Firefox/47.0")	//http请求的浏览器设置
                .timeout(20)   //http连接时长
                .method(Connection.Method.GET);  //请求类型是get请求，http请求还是post,delete等方式
        //获取页面的html文档
        Document doc = conn.get();
        Element body = doc.body();
        
        //将爬取出来的文章封装到Artcle中，并放到ArrayList里面去
        List<Article> resultList = new ArrayList<Article>();

        Element articleListDiv = body.getElementById("article_list");
        Elements articleList = articleListDiv.getElementsByClass("list_item");
        for(Element article : articleList){
        	Article articleEntity = new Article();
            Element linkNode = (article.select("div h1 a")).get(0);         
            Element desptionNode = (article.getElementsByClass("article_description")).get(0);
            Element articleManageNode = (article.getElementsByClass("article_manage")).get(0);

            articleEntity.setAddress(linkNode.attr("href"));
            articleEntity.setTitle(linkNode.text());
            articleEntity.setDesption(desptionNode.text());
            articleEntity.setTime(articleManageNode.select("span:eq(0").text());

            resultList.add(articleEntity);
        }
        
        //遍历输出ArrayList里面的爬取到的文章
        System.out.println("文章总数:" + resultList.size());
        for(Article article : resultList) {
        	System.out.println("文章绝对路劲地址:http://blog.csdn.net" + article.getAddress());
        }
    }
	
}