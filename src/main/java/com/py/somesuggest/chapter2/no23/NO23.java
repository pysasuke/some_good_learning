package com.py.somesuggest.chapter2.no23;

/**
 * 不要让类型默默转换
 * 注意：基本类型转换时，使用主动声明方式减少不必要的Bug
 * Created by Administrator on 2017/9/16 0016.
 */
public class NO23 {
    //光速是30万公里/秒，常量
    public static final int LIGHT_SPEED = 30 * 10000 * 1000;

    public static void main(String[] args) {
        System.out.println("题目1：月亮光照射到地球需要1秒，计算月亮和地球的距离。");
        long dis1 = LIGHT_SPEED * 1;
        System.out.println("月亮与地球的距离是：" + dis1 + "米");
        System.out.println("---------------------------");
        System.out.println("题目2：太阳光照射到地球需要8分钟，计算太阳和地球的距离。");
        //可能要超出整数范围，使用long型
        //因为dis2的三个运算参数都是int类型，三者相乘的结果虽然也是int类型，但是已经超过了int的最大值，所以其值就是负值了
//        long dis2 = LIGHT_SPEED * 60 * 8;    //-2028888064  NOT DO THIS
        long dis2 = LIGHT_SPEED * 60L * 8;
//        long dis2 = 1L * LIGHT_SPEED * 60 * 8;  //实际开发中，更通用(主动声明式类型转换(注意不是强制类型转换))
        System.out.println("太阳与地球的距离是：" + dis2 + "米");

    }
}
