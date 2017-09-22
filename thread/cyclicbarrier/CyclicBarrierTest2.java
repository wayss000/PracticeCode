package pers.wayss.allTest;

import java.util.Random;  
import java.util.concurrent.BrokenBarrierException;  
import java.util.concurrent.CyclicBarrier;  
  
public class CyclicBarrierTest2 {  
    public static void main(String[] args) {  
        CyclicBarrier barrier = new CyclicBarrier(5, new TotalTask());  
        new Thread(new StateTask(barrier, "湖南")).start();  
        new Thread(new StateTask(barrier, "广东")).start();  
        new Thread(new StateTask(barrier, "北京")).start();  
        new Thread(new StateTask(barrier, "上海")).start();  
        new Thread(new StateTask(barrier, "重庆")).start();  
    }  
}  
  
class TotalTask implements Runnable{  
  
    public void run() {  
        System.out.println("统计全国GDP！");  
    }  
}  
  
class StateTask implements Runnable{  
    private CyclicBarrier barrier;  
    private String name;  
      
    public StateTask(CyclicBarrier barrier, String name) {  
        this.barrier = barrier;  
        this.name = name;  
    }  
  
    public void run() {  
        try {  
            Thread.sleep(1000 * new Random().nextInt(5));  
            System.out.println(name + "GDP统计完毕！");  
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
    }  
}  