import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Wayss.
 * @date 2019/7/9.
 */
public class ThreadPoolDemo {

    public static void main(String [] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 2000, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1));

        for (int i = 0; i < 1000; i++) {
            WorkThread workThread = new WorkThread();
            threadPoolExecutor.execute(workThread);
        }
        System.out.println("threadPoolExecutor.shutdown()");
        threadPoolExecutor.shutdown();
    }
}

class WorkThread implements Runnable {

    public void run() {
        try {

            System.out.println(Thread.currentThread().getName() + "===执行开始");
            //方案一：模拟等待用sleep，不占用CPU
            TimeUnit.SECONDS.sleep(10);
            //方案二：模拟等待用for,占用CPU
            //for (long i = 0; i < 9999999999L; i++) ;
            System.out.println(Thread.currentThread().getName() + "===执行结束");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
