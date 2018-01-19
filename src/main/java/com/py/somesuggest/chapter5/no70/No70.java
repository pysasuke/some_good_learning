package com.py.somesuggest.chapter5.no70;

import java.util.ArrayList;
import java.util.List;

/**
 * 子列表只是原列表的一个视图
 *
 * @author Administrator
 * @date 2017/10/25 0025
 * 注意：subList产生的列表只是一个视图，所有的修改动作直接作用于原列表
 */
public class No70 {
    public static void main(String[] args) {
        //定义一个包含两个字符串的列表
        List<String> list = new ArrayList<>(2);
        list.add("A");
        list.add("B");
        //构造一个包含list列表的字符串列表
        List<String> list2 = new ArrayList<>(list);
        //true
        System.out.println("list == list2? " + list.equals(list2));
        //subList生成与list相同的列表
        /*
        subList方法实现原理：
        它返回的SubList类也是AbstractList的子类，其所以的方法如get、set、add、remove等都是在原始列表上的操作，
        它自身并没有生成一个数组或是链表，也就是子列表只是原列表的一个视图，
        所有的修改动作都反映在了原始列表上。
         */
        List<String> list3 = list.subList(0, list.size());
        //list3增加一个元素
        list3.add("C");
        //false
        System.out.println("list == list2? " + list.equals(list2));
        //true
        System.out.println("list == list3? " + list.equals(list3));
        //3
        System.out.println(list.size());
    }
}
