
public class Main {
    
    public static void main(String [] args){
        SingleBBBObj singleBBBObj = SingleBBBObj.getInstance();
        TestThreadInterrupt tti1 = new TestThreadInterrupt(singleBBBObj, "111");
        TestThreadInterrupt tti2 = new TestThreadInterrupt(singleBBBObj, "222");
        
        Thread t1 = new Thread(tti1);
        t1.start();
        Thread t2 = new Thread(tti2);
        try {
            t2.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}
