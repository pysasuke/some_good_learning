package com.py.somesuggest.chapter2.no25;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 不要让四舍五入亏了一方
 * 注意：根据不同的场景，慎重选择不同的舍入模式，以提高项目的精度，减少算法损失
 * Created by Administrator on 2017/9/17 0017.
 */
public class NO25 {
    public static void main(String[] args) {
        //四舍五入法则
        System.out.println("10.5的近似值：" + Math.round(10.5));
        System.out.println("-10.5的近似值：" + Math.round(-10.5));
        //银行家舍入法则
        //存款
        BigDecimal d = new BigDecimal(888888);
        //月利率，乘3计算利率
        BigDecimal r = new BigDecimal(0.001875 * 3);
        //计算利息
        BigDecimal i = d.multiply(r).setScale(2, RoundingMode.HALF_EVEN);
        System.out.println("季利息是：" + i);
    }
}
