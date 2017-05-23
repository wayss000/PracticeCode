
public class PendingInterrupt extends Object {  
    public static void main(String[] args){  
        //如果输入了参数，则在mian线程中中断当前线程（亦即main线程）  
        if( args.length > 0 ){  
            Thread.currentThread().interrupt();  
        }   
        //获取当前时间  
        long startTime = System.currentTimeMillis();  
        try{  
            Thread.sleep(2000);  
            System.out.println("was NOT interrupted");  
        }catch(InterruptedException x){  
            System.out.println("was interrupted");  
        }  
        //计算中间代码执行的时间  
        System.out.println("elapsedTime=" + ( System.currentTimeMillis() - startTime));  
    }  
}

/*
 * 如果 PendingInterrupt 不带任何命令行参数，
 * 那么线程不会被中断，最终输出的时间差距应该在 2000 附近（具体时间由系统决定，不精确），
 * 如果 PendingInterrupt 带有命令行参数，则调用中断当前线程的代码，
 * 但 main 线程仍然运行，最终输出的时间差距应该远小于 2000，
 * 因为线程尚未休眠，便被中断，
 * 因此，一旦调用 sleep()方法，会立即打印出 catch 块中的信息。
 * 
 * 也就是说，interrupt()方法只能让sleep状态的线程抛出中断异常。
 */
