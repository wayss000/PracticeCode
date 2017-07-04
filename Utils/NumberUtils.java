import java.util.Random;

public class NumberUtils {
    
    private static Random random = new Random();
    
    /**
     * 得到0~range的随机数，随机数包括0不包括range.
     * @param range
     * @return
     */
    public static int getIntRandomNumber(int range){
        int num = 0;
        num = random.nextInt(range);
        return num;
    }
}
