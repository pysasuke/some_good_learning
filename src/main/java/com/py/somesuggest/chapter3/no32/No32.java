package com.py.somesuggest.chapter3.no32;

/**
 * 静态变量一定要先声明后赋值
 * 注意：再次重申变量要先声明后使用，这不是一句废话
 *
 * @author Administrator
 * @date 2017/9/19 0019
 */
public class No32 {
    public static int i = 1;

    static {
        i = 100;
    }

    public static void main(String[] args) {
        //100
        System.out.println(i);
    }
}
