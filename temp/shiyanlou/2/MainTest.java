import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MainTest {
    public static void main(String [] args){
        FileOperate fo = new FileOperate();
        String result = fo.readFile("E:\\code\\javacode\\gongsilianxi\\Test\\src\\words.txt");
        fo.outFile("E:\\code\\javacode\\gongsilianxi\\Test\\src\\words.txt", result);
        
        String [] words = result.split(" ");
        List arrList = Arrays.asList(words);
        ReverseList<String> rlst = new ReverseList<>(arrList);
        Iterable<String> itble = rlst.reversed();
        Iterator<String> it = itble.iterator();
        int i = 0;
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
