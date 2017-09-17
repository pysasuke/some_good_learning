package com.py.somesuggest.chapter1.no10;

import static java.lang.Math.PI;
import static java.lang.Math.abs;

/**
 * 不要在本类中覆盖静态导入的变量和方法
 * Created by Administrator on 2017/9/10 0010.
 */
public class NO10 {
    public static void main(String[] args) {
        System.out.println("PI" + PI);
        System.out.println("abs(100)=" + abs(-100));
    }
}
