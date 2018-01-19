package com.py.somesuggest.chapter5.no76;

import java.util.ArrayList;
import java.util.List;

/**
 * 集合运算时使用更优雅的方式
 *
 * @author Administrator
 * @date 2017/10/29 0029
 */
public class No76 {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("B");
        List<String> list2 = new ArrayList<>();
        list2.add("C");
        list2.add("B");
        //并集(把两个集合加起来)
        list1.addAll(list2);
        //交集(retainAll方法会删除list1中没有出现在list2中的元素)
        list1.retainAll(list2);
        //差集(从list1中删除出现在list2的元素)
        list1.removeAll(list2);
        //无重复的并集
        //删除在list1中出现的元素
        list2.removeAll(list1);
        //把剩余的list2元素加到list1中
        list1.addAll(list2);


    }
}
