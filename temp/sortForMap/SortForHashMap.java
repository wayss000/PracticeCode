import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class SortForHashMap {

    //2017-07-01 00:00:00 = 1498838400000 ms
    private long startTime = 1498838400000L;
    private Map<String,String> hashMap = new HashMap<String,String>();
    
    //根据时间，10ms一个数据，key为时间戳，value为随机数，总共插入13万个数据
    public void initData(){
        long keyNumber = startTime;
        for(int i = 0; i < 130000; i++){
            hashMap.put(String.valueOf(keyNumber), String.valueOf(NumberUtils.getIntRandomNumber(10)));
            //时间自增10ms
            keyNumber = keyNumber + 10;
        }
//        System.out.println(hashMap);
    }
    
    public Map returnMapLongInt(){
        Map<Long,Integer> newMap = new HashMap<Long,Integer>();
        for (Map.Entry<String,String> entry : hashMap.entrySet()) {  
            newMap.put(Long.valueOf(entry.getKey()), Integer.valueOf(entry.getValue()));
        }  
//        System.out.println(newMap);
        return newMap;
    }
    
    public Set sortKey(){
        Set<String> sortkey = new TreeSet<String>(hashMap.keySet());
        Iterator it = sortkey.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }
        return sortkey;
    }
    
    /**
     * 这个算法算出来的结果大于，最后的map.size应该是大于1000的
     */
    public void mergeData(){
        Set sortkey = sortKey();
        int range = hashMap.size() / 1000;
        Iterator it = sortkey.iterator();
        long sumResultKey = 0;
        int sumResultValue = 0;
        int i = 0;
        Map<String,String> resultMap = new HashMap<String,String>();
        while(it.hasNext()){
            if(i == range){
                i = 0;
                sumResultKey = 0;
                sumResultValue = 0;
            }
            Object o = it.next();
            sumResultKey += Long.valueOf(o.toString());
            sumResultValue += Long.valueOf(hashMap.get(o));
            i++;
            if(i == range - 1){
                long key = sumResultKey / range;
                int value = sumResultValue / range;
                resultMap.put(String.valueOf(key), String.valueOf(value));
            }
        }
        System.out.println("hashMap.size:" + hashMap.size());
        System.out.println("resultMap.size:" + resultMap.size());
    }
    
    public SortForHashMap(){
        initData();
    }
}
