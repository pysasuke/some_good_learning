package com.py.somesuggest.chapter1.no1;

/**
 * 不要在常量和变量中出现易混淆的字母
 * 注意：字母"l"作为长整型标志时务必大写
 * Created by Administrator on 2017/9/10 0010.
 */
public class No1 {
    public static void main(String[] args) {
//        long i = 1l;    NOT DO THIS 如果字母和数字必须混合使用，字母"l"务必大写(L)，字母"O"则增加注释。
        long i = 1L;
        System.out.println("i 的两倍是：" + (i + i));
    }
}
