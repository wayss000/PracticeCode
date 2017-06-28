
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
        singleBBBObj.getSingAAAObj().showMessage();
        System.out.println(Thread.currentThread().getName() + "Set currentThread interrupt");
        Thread.currentThread().interrupt();
        System.out.println(Thread.currentThread().getName() + "after:");
        singleBBBObj.getSingAAAObj().showMessage();
    }

}
