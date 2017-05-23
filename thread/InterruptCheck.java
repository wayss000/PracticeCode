
public class InterruptCheck extends Object{  
    public static void main(String[] args){  
        Thread t = Thread.currentThread();  
        System.out.println("Point A: t.isInterrupted()=" + t.isInterrupted());  
        //待决中断，中断自身  
        t.interrupt();  
        System.out.println("Point B: t.isInterrupted()=" + t.isInterrupted());  
        System.out.println("Point C: t.isInterrupted()=" + t.isInterrupted());  

        try{  
            Thread.sleep(2000);  
            System.out.println("was NOT interrupted");  
        }catch( InterruptedException x){  
            System.out.println("was interrupted");  
        }  
        //抛出异常后，会清除中断标志，这里会返回false  
        System.out.println("Point D: t.isInterrupted()=" + t.isInterrupted());  
    }  
}

/*
 * interrupt()是给线程设置一个中断标志，
 * 当调用interrupt()之后，isInterrupted()就会返回true
 * 当线程执行sleep()时，被设置中断标志的线程会抛出中断异常，
 * 当线程抛出中断异常后，中断标志去掉，isInterrunpted()返回false
 * 
 * interrupt()只是让线程不在睡觉sleep()，并不是立马kill -9 线程，
 * 抛出中断异常后，线程依然继续往下执行。
 */