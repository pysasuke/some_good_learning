package com.py.somesuggest.chapter1.no9;

import static java.lang.Math.PI;

/**
 * 使用静态导入
 *
 * @author Administrator
 * @date 2017/9/10 0010
 */
public class MathUtils2 {
    public static double calCircleArea(double r) {
        return PI * r * r;
    }

    public static double calVallArea(double r) {
        return 4 * PI * r * r;
    }
}
