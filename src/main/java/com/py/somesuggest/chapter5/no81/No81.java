package com.py.somesuggest.chapter5.no81;

import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 非稳定排序推荐使用List
 *
 * @author Administrator
 * @date 2017/10/30 0030
 * 注意：SortedSet中的元素被修改后可能会影响其排序位置。
 */
/*
对于不变量的排序，例如直接量(也就是8个基本类型)、String类型等，推荐使用TreeSet，
而对于可变量，例如我们自己写的类，可能会在逻辑处理中改变其排序关键值的，则建议使用List自行排序。
 */
public class No81 {
    public static void main(String[] args) {
        SortedSet<Person> set = new TreeSet<>();
        //身高180CM
        set.add(new Person(180));
        //身高175CM
        set.add(new Person(175));
        //身高最矮的人大变身
        set.first().setHeight(185);
        //(1)set重排序(2)彻底重构掉TreeSet，使用List解决问题
        set = new TreeSet<>(new ArrayList<>(set));
        for (Person person : set) {
            System.out.println("身高:" + person.getHeight());
        }
        /*
        身高:175
        身高:180
         */
        /*
        身高:185
        身高:180
         */
        /*
        SortedSet接口(TreeSet实现了该接口)只是定义了在给集合加入元素时将其进行排序，
        并不能保证元素修改后的排序结果
         */
    }

    static class Person implements Comparable<Person> {
        //身高
        private int height;

        public Person(int height) {
            this.height = height;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        //按照身高排序
        @Override
        public int compareTo(Person o) {
            return height - o.height;
        }
    }
}

