package com.py.somesuggest.chapter_3.no32;

/**
 * 静态变量一定要先声明后赋值
 * 注意：再次重申变量要先声明后使用，这不是一句废话
 * Created by Administrator on 2017/9/19 0019.
 */
public class NO32 {
    public static  int i=1;
    static {
        i=100;
    }
    public static void main(String[] args) {
        System.out.println(i);    //100
    }
}
