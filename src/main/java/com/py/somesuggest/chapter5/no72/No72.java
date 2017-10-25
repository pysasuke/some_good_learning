package com.py.somesuggest.chapter5.no72;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 生成子列表后不要再操作原始列表
 * Created by Administrator on 2017/10/25 0025.
 * subList生成子列表后，保持原始列表的只读状态。
 */
//只要生产的自列表多于一个，则任何一个自列表就都不能修改了，否则就会抛出ConcurrentModificationException异常。
public class No72 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(4);
        list.add("A");
        list.add("B");
        list.add("C");
        List<String> subList = list.subList(0, 2);
        //原始列表增加一个元素
//        list.add("D");    //NOT DO THIS
        //设置列表为只读状态
        list = Collections.unmodifiableList(list);
        /*
        doReadSomething(list)
        doReadAndWriteSomething(subList)
         */
        System.out.println("原始列表长度:" + list.size());
        /*
        因为subList取出来的列表是原来列表的一个视图，原数据集(代码中的list变量)修改了，
        但是subList取出来的自列表不会重新生成一个新列表(这点与数据库视图是不相同的)，
        后面在对子列表继续操作时，就会检测到修改计数器与预期的不同，于是就抛出了并发修改异常。
         */
        System.out.println("子列表长度:" + subList.size());    //Exception in thread "main" java.util.ConcurrentModificationException
    }
}
