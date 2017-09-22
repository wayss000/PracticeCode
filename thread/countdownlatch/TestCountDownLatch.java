package pers.wayss.allTest;

import java.util.concurrent.CountDownLatch;

/**
 * 练习使用CountDownLatch类，来控制线程之间等待。
 * 
 * @author Wayss
 *
 * 2017年9月21日 上午12:32:21
 */
public class TestCountDownLatch {

    public static void main(String[] args) {
        
        fun1();
//        fun2();
    }

    /**
     * 用CountDownLatch实现，main线程在三个线程运行完之后再继续运行
     */
    private static void fun2() {
        CountDownLatch cdt = new CountDownLatch(3);
        TestThread t1 = new TestThread("one", cdt);
        TestThread t2 = new TestThread("two", cdt);
        TestThread t3 = new TestThread("three", cdt);
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
        try {
            cdt.await();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("main线程运行完毕");
    }

    /**
     * 新建三个线程，并运行后，main线程会直接执行完，三个线程各自独立的运行
     */
    private static void fun1() {
        
        TestThread t1 = new TestThread("one");
        TestThread t2 = new TestThread("two");
        TestThread t3 = new TestThread("three");
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
        System.out.println("main线程运行完毕");
    }

}

class TestThread implements Runnable{

    private String name;
    private CountDownLatch cdt;
    
    public TestThread(String name){
        this.name = name;
    }
    
    public TestThread(String name, CountDownLatch cdt){
        this(name);
        this.cdt = cdt;
    }
    
    public void run() {
        int sum = 10;
        for(int i = 0; i < sum; i++){
            System.out.println(name + ":::" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(cdt != null){
            System.out.println(name + "---countdownlatch---运行结束");
            cdt.countDown();
        }else{
            System.out.println(name + "---运行结束");
        }
    }
    
}