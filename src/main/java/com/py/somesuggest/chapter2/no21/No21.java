package com.py.somesuggest.chapter2.no21;

import java.util.Scanner;

/**
 * 用偶判断，不用奇判断
 *
 * @author Administrator
 * @date 2017/9/16 0016
 */
public class No21 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入多个数字判断奇偶：");
        //0
        System.out.println(-1 / 2);
        //-1
        System.out.println(-1 % 2);
        //-1
        System.out.println(-2 / 2);
        //0
        System.out.println(-2 % 2);
        //-1
        System.out.println(remainder(-1, 2));
        while (input.hasNext()) {
            int i = input.nextInt();
            //NOT DO THIS  当i为负数时
//            String str = i + "->" + (i % 2 == 1 ? "奇数" : "偶数");
            //NOT DO THIS  当i为负数时
            String str = i + "->" + (i % 2 == 0 ? "偶数" : "奇数");
            System.out.println(str);
        }
    }

    /**
     * 模拟取余计算，dividend被除数，divisor除数
     */
    public static int remainder(int dividend, int divisor) {
        return dividend - dividend / divisor * divisor;
    }
}
