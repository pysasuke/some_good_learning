package com.py.somesuggest.chapter2.no29;

/**
 *
 * @author Administrator
 * @date 2017/9/18 0018
 */
public class Example {
    public static void main(String[] args) {
        int i = 100;
//        f(i);    NOT DO THIS //编译失败  i是一个int类型，不能自动转为Long型
        //int先加宽转变成long，然后自动转换成Long
        long l = (long) i;
        f(l);
    }

    public static void f(Long i) {

    }
}
