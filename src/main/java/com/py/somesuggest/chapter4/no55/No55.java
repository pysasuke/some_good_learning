package com.py.somesuggest.chapter4.no55;

/**
 * 注意字符串的位置
 *
 * @author Administrator
 * @date 2017/10/22 0022
 * 注意：在"+"表达式中，String字符串具有最高优先级
 */
/*
Java对加号的处理机制：
    在使用加号进行计算的表达式中，只要遇到String字符串，则所有的数据都会转成String类型进行拼接，
    如果是原始数据，则直接拼接，如果是对象，则调用toString方法的返回值然后拼接
 */
public class No55 {
    public static void main(String[] args) {
        String str1 = 1 + 2 + " apples";
        String str2 = "apples:" + 1 + 2;
        //3 apples
        System.out.println(str1);
        //apples:12
        System.out.println(str2);
    }
}
