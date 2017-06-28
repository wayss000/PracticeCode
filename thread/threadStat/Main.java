
public class Main {
    
    public static void main(String [] args){
        //拿到B对象的单例，也就是拿到了A对象的单例
        SingleBBBObj singleBBBObj = SingleBBBObj.getInstance();
        TestThreadInterrupt tti1 = new TestThreadInterrupt(singleBBBObj, "111");
        TestThreadInterrupt tti2 = new TestThreadInterrupt(singleBBBObj, "222");
        
        Thread t1 = new Thread(tti1);
        t1.start();
        Thread t2 = new Thread(tti2);
        try {
            //让线程2先睡1秒，目的是让线程1先执行到“工作5秒”时，再启动线程2
            t2.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}

/*
 程序的执行结果：
111before:
SingleAAAObj@4059e324
111SingleObject isInterrupted:false
111Set currentThread interrupt
111after:
SingleAAAObj@4059e324
111SingleObject isInterrupted:true
222before:
SingleAAAObj@4059e324
222SingleObject isInterrupted:false
222Set currentThread interrupt
222after:
SingleAAAObj@4059e324
222SingleObject isInterrupted:true
After 5 seconds Thread status:
SingleAAAObj@4059e324
111SingleObject isInterrupted:true
After 5 seconds Thread status:
SingleAAAObj@4059e324
222SingleObject isInterrupted:true
从执行结果中看出来，当线程1的中断状态设置为true后，线程1继续工作，
线程2自己独立的线程状态还是false，只有当线程2自己设置自己的线程中断标志为true时，才为true.
这是Demo证实了当Thread.currentThread().interrupt()时，我把线程状态和对象状态搞混了。
 */ 
