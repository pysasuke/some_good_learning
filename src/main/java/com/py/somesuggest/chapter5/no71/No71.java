package com.py.somesuggest.chapter5.no71;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 推荐使用subList处理局部列表
 *
 * @author Administrator
 * @date 2017/10/25 0025
 */
public class No71 {
    public static void main(String[] args) {
        //初始化一个固定长度，不可变的列表
        List<Integer> initData = Collections.nCopies(100, 0);
        //转换为课表列表
        List<Integer> list = new ArrayList<>(initData);
        //遍历删除符合条件的元素
//        for (int i = 0, size = list.size(); i < size; ++) {
//            if (i >= 20 && i < 30) {
//                list.remove(i);
//            }
//        }
        //删除指定范围的元素
        //因为subList返回的List是原始列表的一个视图，删除这个视图中的所有元素，最终就会反映到原始列表上。
        list.subList(20, 30).clear();
    }

}
