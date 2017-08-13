package pers.wayss.crawler;

/**
 * 实现accept接口，过滤图片前缀不符的url
 * @author Wayss
 *
 * 2017年8月13日 下午11:12:19
 */
public interface Filter {

    boolean accept(String url);
}