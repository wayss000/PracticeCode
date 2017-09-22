package pers.wayss.allTest;

import java.util.Random;  
import java.util.concurrent.BrokenBarrierException;  
import java.util.concurrent.CyclicBarrier;  
  
public class CyclicBarrierTest1 {  
    public static void main(String[] args) {  
        // 如果将参数改为4，但是下面只加入了3个选手，这永远等待下去  
        CyclicBarrier barrier = new CyclicBarrier(3);  
        for (int i = 0; i < 3; i++) {  
            new Thread(new Runner(barrier, (i + 1) + "号选手")).start();  
        }  
    }  
}  
  
class Runner implements Runnable{  
    // 公共屏障点 (common barrier point)  
    private CyclicBarrier barrier;  
    private String name;  
      
    public Runner(CyclicBarrier barrier, String name) {  
        this.barrier = barrier;  
        this.name = name;  
    }  
  
    public void run() {  
        try {  
            Thread.sleep(1000 * new Random().nextInt(5));  
            System.out.println(name + "已经准备好了！");  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        try {  
            barrier.await();  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        } catch (BrokenBarrierException e) {  
            e.printStackTrace();  
        }  
        System.out.println(name + "起跑了！");  
    }  
} 