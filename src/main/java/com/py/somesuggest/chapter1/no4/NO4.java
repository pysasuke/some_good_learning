package com.py.somesuggest.chapter1.no4;

import java.text.NumberFormat;

/**
 * 避免带有变长参数的方法重载
 * Created by Administrator on 2017/9/10 0010.
 */
public class NO4 {
    //简单折扣计算
    public void calPrice(int price, int discount) {
        float knockdownPrice = price * discount / 100.0F;
        System.out.println("简单折扣后的价格是：" + formatCurrency(knockdownPrice));
    }

    //复杂折扣计算
//    public void calPrice(int price, int... discounts) {    //NOT DO THIS  参数范畴覆盖了重载的其他方法(简单折扣计算)
//        float knockdownPrice = price;
//        for (int discount : discounts) {
//            knockdownPrice = knockdownPrice * discount / 100;
//        }
//        System.out.println("复杂折扣后的价格是：" + formatCurrency(knockdownPrice));
//    }

    //格式化成本的货币形式
    private String formatCurrency(float price) {
        return NumberFormat.getCurrencyInstance().format(price / 100);
    }

    public static void main(String[] args) {
        NO4 no4 = new NO4();
        /*
        因为int是一个原生数据类型，而数组本身是一个对象，编译器想要"偷懒"，于是它会从最
        简单的开始"猜想"，只要符合编译条件的即可通过
         */
        no4.calPrice(49900, 75);    //调用简单折扣计算方法
    }
}
