package com.py.somesuggest.chapter1.no9;


import java.text.NumberFormat;

import static java.lang.Double.*;
import static java.lang.Integer.*;
import static java.lang.Math.*;
import static java.text.NumberFormat.*;
/**
 * 少用静态导入
 *
 * @author Administrator
 * @date 2017/9/10 0010
 */
public class No9 {
    /**
     * 输入半径和精度要求，计算面积
     */
    public static void main(String[] args) {
        /*
         对于静态导入，一定要遵循两个规则
            不使用*(星号)通配符，除非是导入静态常量类(只包含常量的类或者接口)。
            方法名是具有明确、清晰表象意义的工具类(见DaoTest)
         */
        double s = PI * parseDouble(args[0]);
        NumberFormat nf = getInstance();
        nf.setMaximumFractionDigits(parseInt(args[1]));
        formatMessage(nf.format(s));
    }

    public static void formatMessage(String s) {
        System.out.println("圆面积是：" + s);
    }
}
