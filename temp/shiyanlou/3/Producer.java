import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {
    private final BlockingQueue<String> queue;
    
    private int produceNum = 10;
    private String produceMess = "complete production:Course";
    
    public Producer(BlockingQueue<String> queue){
        this.queue = queue;
    }
    
    public void run(){
        for(int i = 1; i <= produceNum; i++){
            try {
                queue.put(String.valueOf(i));
                System.out.println(produceMess + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
