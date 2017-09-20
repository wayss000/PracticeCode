package pers.wayss.allTest;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest3 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        String[] names = { "爱因斯坦", "牛顿", "罗素", "高斯" };
        final CyclicBarrier barrier = new CyclicBarrier(names.length); // 四个人同时到达
        for (String name : names) {
            service.execute(new Member(barrier, name, names.length));
        }
        service.shutdown();
    }
}

class Member implements Runnable {
    private CyclicBarrier barrier;
    private String name;
    private int totalMember;

    public Member(CyclicBarrier barrier, String name, int totalMember) {
        this.barrier = barrier;
        this.name = name;
        this.totalMember = totalMember;
    }

    public void run() {
        try {
            // 公司集合
            Thread.sleep(1000 * new Random().nextInt(5));
            System.out.println(name + "到了公司！");
            if (barrier.getNumberWaiting() == totalMember - 1) {
                System.out.println("所有人员已到达公司，准备去聚餐...");
            }
            barrier.await();
            // 聚餐
            Thread.sleep(1000 * new Random().nextInt(5));
            System.out.println(name + "到了聚餐地点！");
            if (barrier.getNumberWaiting() == totalMember - 1) {
                System.out.println("所有人员已到达聚餐地点，准备吃饭...");
            }
            barrier.await();
            // K歌
            Thread.sleep(1000 * new Random().nextInt(5));
            System.out.println(name + "到了K歌地点！");
            if (barrier.getNumberWaiting() == totalMember - 1) {
                System.out.println("所有人员已到达K歌地点，一起嗨起来！");
            }
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}