package pers.wayss.crawler;

/**
 * 打印运行时信息
 * @author Wayss
 *
 * 2017年8月13日 下午12:40:31
 */
public class MyLogger {
    /**
     * 打印运行到当前的调试信息
     * @param clz 当前类
     * @param str 需要打印的额外信息
     */
    public static void printInfo(Class clz,String str){
        System.out.println(clz.getClass().getName()+":"+str);
    }
}
