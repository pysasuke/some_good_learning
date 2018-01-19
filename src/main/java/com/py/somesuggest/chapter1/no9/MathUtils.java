package com.py.somesuggest.chapter1.no9;

/**
 * 不使用静态导入
 *
 * @author Administrator
 * @date 2017/9/10 0010
 */
public class MathUtils {
    /**
     * 计算圆面积
     */
    public static double calCircleArea(double r) {
        return Math.PI * r * r;
    }

    public static double calBallArea(double r) {
        return 4 * Math.PI * r * r;
    }
}
