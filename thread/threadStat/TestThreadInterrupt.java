
public class TestThreadInterrupt implements Runnable{

    public SingleBBBObj singleBBBObj;
    public String name;
    
    public TestThreadInterrupt(SingleBBBObj singleBBBObj, String name){
        this.singleBBBObj = singleBBBObj;
        this.name = name;
    }
    
    public void run(){
        Thread.currentThread().setName(name);
        System.out.println(Thread.currentThread().getName() + "before:");
        //线程设置中断标志前查看线程中断状态
        singleBBBObj.getSingAAAObj().showThreadStatus();
        System.out.println(Thread.currentThread().getName() + "Set currentThread interrupt");
        //线程设置中断标志
        Thread.currentThread().interrupt();
        System.out.println(Thread.currentThread().getName() + "after:");
        //线程设置中断标志后查看线程中断状态
        singleBBBObj.getSingAAAObj().showThreadStatus();
        long nowTime = System.currentTimeMillis();
        while(true){
            //让线程执行5秒中
            if(System.currentTimeMillis() - 5000 > nowTime){
                break;
            }
        }
        System.out.println("After 5 seconds Thread status:");
        singleBBBObj.getSingAAAObj().showThreadStatus();
    }

}
