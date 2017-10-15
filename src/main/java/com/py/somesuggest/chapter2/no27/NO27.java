package com.py.somesuggest.chapter2.no27;

/**
 * 谨慎包装类型的大小比较
 * Created by Administrator on 2017/9/17 0017.
 */
//只要是两个对象之间的比较就应该采用相应的方法，而不是通过java的默认机制来处理，除非你确定对此非常了解
public class NO27 {
    public static void main(String[] args) {
        Integer i = new Integer(100);
        Integer j = new Integer(100);
        compare(i, j);
    }

    //比较两个包装对象大小
    public static void compare(Integer i, Integer j) {
//        System.out.println(i == j);    //false    //NOT DO THIS 两个对象，两个地址
        System.out.println(i.compareTo(j) == 0 ? true : false);
        System.out.println(i > j);
        System.out.println(i < j);
    }
}
