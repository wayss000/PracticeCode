import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainTest {

    public static void main(String[] args) {
        //练习使用线程池模拟
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);
        Producer procducer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        
        ExecutorService exec = Executors.newFixedThreadPool(2);
        exec.submit(procducer);
        exec.submit(consumer);
        exec.shutdown();
    }

}
