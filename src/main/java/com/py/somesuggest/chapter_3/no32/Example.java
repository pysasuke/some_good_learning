package com.py.somesuggest.chapter_3.no32;

/**
 * Created by Administrator on 2017/9/19 0019.
 */
public class Example {
    static {
        i = 100;
    }

    public static int i=1;
    /*能编译通过
    静态变量是在类初始化时首先被加载的，JVM会去查找类中所有的静态声明，
    然后分配空间，注意这时候只是完成了地址空间的分配，还没有赋值，之后
    JVM会根据类中静态赋值(包括静态类赋值和静态块赋值)的先后顺序来执行
     */
    public static void main(String[] args) {
        System.out.println(i);    //1
    }
}
