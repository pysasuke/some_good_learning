package com.py.somesuggest.chapter2.no22;

import java.math.BigDecimal;

/**
 * 用整数类型处理货币
 *
 * @author Administrator
 * @date 2017/9/16 0016
 */
public class No22 {
    public static void main(String[] args) {
        //0.40000000000000036    计算机中浮点数有可能(注意是可能)是不准确的，它只能无限接近准确值，而不能完全精确
        System.out.println(10.00 - 9.60);
        //建议一(使用BigDecimal)(个人建议使用BigDecimal)
        System.out.println(new BigDecimal("10.00").subtract(new BigDecimal("9.60")));
        //建议二(使用整型)
        System.out.println(((1000-960)/100d));
    }
}
