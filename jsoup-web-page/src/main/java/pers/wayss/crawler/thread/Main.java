package pers.wayss.crawler.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author Wayss.
 * @date 2019/7/4.
 */
@Slf4j
public class Main {

    private static final int WAIT_SECOND_TIME = 10;

    public static void main(String[] args) {
        CrawlerAllPage crawlerAllPage = new CrawlerAllPage();
        ConcurrentHashMap<String, Integer> pageCountRelation = crawlerAllPage.getAllPageUrl();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 600, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1));

        //用信号量控制多线程，在某时刻高并发访问
        Semaphore semaphore = new Semaphore(1, true);

        int i = 1;
        while (pageCountRelation.size() > 0) {
            log.debug("###执行第[" + i + "]次访问任务");
            log.debug("###剩余URL数量：" + pageCountRelation.size());
            try {
                //多线程访问博客
                for (String pageUrl : pageCountRelation.keySet()) {
                    ViewPage viewPage = new ViewPage(pageCountRelation, pageUrl, semaphore);
                    threadPoolExecutor.execute(viewPage);
                }
                //如果当前线程池中数量大于博客总数，则继续等待
                while (pageCountRelation.size() > 0 && threadPoolExecutor.getPoolSize() >= pageCountRelation.size()) {
                    log.debug("###当前线程池中的数量：getPoolSize()=" + threadPoolExecutor.getPoolSize());
                    log.debug("###当前线程池中核心线程数的数量：pageCountRelation.size()=" + pageCountRelation.size());
                    //等线程池中其他任务执行完退出
                    TimeUnit.SECONDS.sleep(WAIT_SECOND_TIME);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
        threadPoolExecutor.shutdown();
    }
}
