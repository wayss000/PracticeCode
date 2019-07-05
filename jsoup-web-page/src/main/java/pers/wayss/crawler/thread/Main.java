package pers.wayss.crawler.thread;

import java.util.concurrent.*;

/**
 * @author Wayss.
 * @date 2019/7/4.
 */
public class Main {

    private static final int WAIT_SECOND_TIME = 70;

    public static void main(String[] args) {
        CrawlerAllPage crawlerAllPage = new CrawlerAllPage();
        ConcurrentHashMap<String, Integer> pageCountRelation = crawlerAllPage.getAllPageUrl();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(100, 200, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1));

        //用信号量控制多线程，在某时刻高并发访问
        Semaphore semaphore = new Semaphore(1,true);

        int i = 1;
        while (pageCountRelation.size() > 0) {
            System.out.println("执行第[" + i + "]次访问任务");
            System.out.println("剩余URL数量：" + pageCountRelation.size());
            try {
                //多线程访问博客
                for (String pageUrl : pageCountRelation.keySet()) {
                    ViewPage viewPage = new ViewPage(pageCountRelation, pageUrl, semaphore);
                    threadPoolExecutor.execute(viewPage);
                }
                //每次启动多线程后等待70秒，目的是等线程池中其他任务执行完退出
                TimeUnit.SECONDS.sleep(WAIT_SECOND_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }

    }
}
