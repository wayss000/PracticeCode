
/**
 * 一个判断字符串为空的工具类
 * @author Wayss
 * Create time 2017-06-29
 *
 */
public class StringUtils {
    /**
     * 接收N(1<=N)个String类型的参数，返回是否都不为null
     * @param s
     * @return
     */
    public static boolean allIsNotNull(String... s){
        if(s.length == 0){
            return false;
        }
        for(String str : s){
            if(str == null){
                return false;
            }
        }
        return true;
    }

    /**
     * 接收N(1<=N)个String类型的参数，返回是否都不为null或者都不为空串""
     * @param s
     * @return
     */
    public static boolean allIsNotEmpty(String... s){
        if(s.length == 0){
            return false;
        }
        for(String str : s){
            if(str == null){
                return false;
            }else{
                if(str.equals("")){
                    return false;
                }
            }
        }
        return true;
    }
}