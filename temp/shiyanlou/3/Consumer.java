import java.util.concurrent.BlockingQueue;

class Consumer implements Runnable {
    private final BlockingQueue<String> queue;
    
    private int consumeNum = 10;
    private String consumeMess = "Complete consumption:Course";
    
    public Consumer(BlockingQueue queue){
        this.queue = queue;
    }
    
    public void run(){
        for(int i = 1; i <= consumeNum; i++){
            try {
                String str = queue.take();
                System.out.println(consumeMess + str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
