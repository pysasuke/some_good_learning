package com.py.somesuggest.chapter5.no78;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 减少HashMap中元素的数量
 *
 * @author Administrator
 * @date 2017/10/29 0029
 * 尽量让HashMap中的元素少量并简单
 */
/*
只要HashMap的size大于数组长度的0.75倍时，就开始扩容(2被长度的递增)
ArrayList在小于数组长度的时候才开始扩容(扩容为1.5倍)
 */
public class No78 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        final Runtime rt = Runtime.getRuntime();
        //JVM终止前记录内存信息
        rt.addShutdownHook(new Thread() {
            @Override
            public void run() {
                StringBuffer sb = new StringBuffer();
                long heapMaxSize = rt.maxMemory() >> 20;
                sb.append("最大可以内存：" + heapMaxSize + "M\n");
                long total = rt.totalMemory() >> 20;
                sb.append("堆内存大小：" + total + "M\n");
                long free = rt.freeMemory() >> 20;
                sb.append("空闲内存：" + free + "M\n");
            }
        });
        //放入近40万键值对
        for (int i = 0; i < 393217; i++) {
            map.put("key" + i, "value" + i);
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 400000; i++) {
            list.add("key" + i);
            list.add("value" + i);
        }
    }
}
