package com.py.somesuggest.chapter7.no105;

import java.lang.reflect.Array;

/**
 * 动态加载不适合数组
 * Created by Administrator on 2017/11/7 0007.
 * 注意：通过反射操作数组使用Array类，不要采用通用的反射处理API。
 */
public class No105 {
    public static void main(String[] args) {
        //动态创建数组
        String[] strs = (String[]) Array.newInstance(String.class, 8);
        //创建一个多维数组
        int[][] ints =(int[][])Array.newInstance(int.class,2,3);
    }
}
