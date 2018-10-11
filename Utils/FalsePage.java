package pers.wayss.AllTest;

import java.util.ArrayList;
import java.util.List;

/**
 * 假分页工具类
 *
 * @author Wayss.
 * @date 2018/10/11.
 */
public class FalsePage {

    /**
     * 假分页。返回当前页的集合。
     *
     * @param all      总集合
     * @param pageNum  页号，第一页从0开始。
     * @param pageSize 页面大小
     * @return
     */
    public static List getPage(List all, int pageNum, int pageSize) {

        //1.计算起始下标
        int fromIndex = pageNum * pageSize;
        //1.1 若起始pageNum超过集合总数，则返回空集合
        if (fromIndex > all.size()) {
            return new ArrayList();
        }

        //2.计算结束下标
        int toIndex = fromIndex + pageSize;
        //2.1需要判断，最后一页若不满足pageSize的情况
        if (toIndex > all.size()) {
            toIndex = all.size();
        }

        //3.利用subList()函数实现截取
        return all.subList(fromIndex, toIndex);
    }

}
