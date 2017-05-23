
public class SleepInterrupt extends Object implements Runnable{  
    public void run(){  
        try{  
            System.out.println("in run() - about to sleep for 20 seconds");  
            Thread.sleep(20000);  
            System.out.println("in run() - woke up");  
        }catch(InterruptedException e){  
            System.out.println("in run() - interrupted while sleeping");  
            //处理完中断异常后，返回到run（）方法人口，  
            //如果没有return，线程不会实际被中断，它会继续打印下面的信息  
//            return;
            //也就是说，interrupt()方法只是让线程抛出一个中断异常,
            //然后线程继续往下执行，
            //所以，如果我们要用interrunp()方法让线程停止，则必须在捕获到终端异常后，return
        }  
        System.out.println("in run() - leaving normally");  
    }  

    public static void main(String[] args) {  
        SleepInterrupt si = new SleepInterrupt();  
        Thread t = new Thread(si);  
        t.start();  
        //主线程休眠2秒，从而确保刚才启动的线程有机会执行一段时间  
        try {  
            Thread.sleep(2000);   
        }catch(InterruptedException e){  
            e.printStackTrace();  
        }  
        System.out.println("in main() - interrupting other thread");  
        //中断线程t  
        t.interrupt();  
        System.out.println("in main() - leaving");  
    }  
} 