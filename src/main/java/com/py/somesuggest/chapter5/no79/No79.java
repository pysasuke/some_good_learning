package com.py.somesuggest.chapter5.no79;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 集合中的哈希码不要重复
 * Created by Administrator on 2017/10/30 0030.
 * 注意：HashMap中的hashCode应避免冲突
 */
/*
如果新加入的键值对的hashCode是唯一的，那直接插入到数组中，它Entry的next值则为null；
如果新加入的键值对的hashCode与其他元素冲突，则替换掉数组中的当前值，
并把新加入的Entry的next变量指向被替换掉的元素
 */
public class No79 {
    public static void main(String[] args) {
        int size = 10000;
        List<String> list = new ArrayList<>(size);
        //初始化
        for (int i = 0; i < size; i++) {
            list.add("value" + i);
        }
        //记录开始时间，单位纳秒
        long start = System.nanoTime();
        //开始查找
        list.contains("value" + (size - 1));
        //记录结束时间，单位纳秒
        long end = System.nanoTime();
        System.out.println("list执行时间:" + (end - start) + "ns");    //list执行时间:1218452ns
        //Map的查找时间
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            map.put("key" + i, "value" + i);
        }
        start = System.nanoTime();
        map.containsKey("key" + (size - 1));
        end = System.nanoTime();
        System.out.println("map执行时间:" + (end - start) + "ns");    //map执行时间:37358ns

    }
}
