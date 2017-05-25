import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args) {
        // 采用新特性来启动和管理线程——内部使用线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        // 只允许5个线程同时访问
        final Semaphore semp = new Semaphore(5);
        // 模拟10个客户端访问
        for (int index = 0; index < 10; index++) {
            final int num = index;
            Runnable run = new Runnable() {
                public void run() {
                    try {
                        // 获取许可
                        semp.acquire();
                        System.out.println("线程" + Thread.currentThread().getName() + "获得许可：" + num);
                        // 模拟耗时的任务
                        for (int i = 0; i < 999999999; i++)
                            ;
                        // 释放许可
                        semp.release();
                        System.out.println("线程" + Thread.currentThread().getName() + "释放许可：" + num);
                        System.out.println(
                                "线程" + Thread.currentThread().getName() + "说：当前允许进入的任务个数：" + semp.availablePermits());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            exec.execute(run);
        }
        // 关闭线程池
        exec.shutdown();
    }
}

/* 
 * 我的执行结果：（）中为我分析的结果
线程pool-1-thread-1获得许可：0
线程pool-1-thread-1释放许可：0
线程pool-1-thread-1说：当前允许进入的任务个数：5（正确）
线程pool-1-thread-2获得许可：1
线程pool-1-thread-3获得许可：2
线程pool-1-thread-3释放许可：2
线程pool-1-thread-3说：当前允许进入的任务个数：5（执行这一步时，“许可1”并没有被释放，也就是说，允许进入的任务数是4，而不是5）
线程pool-1-thread-2释放许可：1（此时，允许进入的任务数才是5）
线程pool-1-thread-6获得许可：5
线程pool-1-thread-5获得许可：4
线程pool-1-thread-6释放许可：5
线程pool-1-thread-5释放许可：4
线程pool-1-thread-5说：当前允许进入的任务个数：5
线程pool-1-thread-2说：当前允许进入的任务个数：3
线程pool-1-thread-6说：当前允许进入的任务个数：5
线程pool-1-thread-7获得许可：6
线程pool-1-thread-4获得许可：3
线程pool-1-thread-4释放许可：3
线程pool-1-thread-4说：当前允许进入的任务个数：4
线程pool-1-thread-7释放许可：6
线程pool-1-thread-7说：当前允许进入的任务个数：5
线程pool-1-thread-10获得许可：9
线程pool-1-thread-10释放许可：9
线程pool-1-thread-10说：当前允许进入的任务个数：4
线程pool-1-thread-9获得许可：8
线程pool-1-thread-9释放许可：8
线程pool-1-thread-9说：当前允许进入的任务个数：5
线程pool-1-thread-8获得许可：7
线程pool-1-thread-8释放许可：7
线程pool-1-thread-8说：当前允许进入的任务个数：5
 * 
 * 从括号中的分析，可以看出，这里并不是线程安全的。
 * 
 */