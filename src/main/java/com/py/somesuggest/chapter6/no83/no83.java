package com.py.somesuggest.chapter6.no83;

/**
 * 推荐使用枚举定义常量
 * Created by Administrator on 2017/10/30 0030.
 * 在项目开发中，推荐使用枚举常量代替接口常量或类常量
 */
/*
虽然枚举常量在很多方面比接口常量和类常量好用，但有一点它是比不上接口常量和类常量的，
那就是继承，枚举类型是不能有继承的
 */
public class no83 {

    public static void main(String[] args) {
        //(3)枚举具有内置方法
        for (Season s : Season.values()) {
            System.out.println(s);
        }

        System.out.println(Season.getComfortableSeason());
        Season.Spring.say();
    }

    //(2)枚举常量属于稳定型(在编译期间限定类型，不允许发生越界的情况)
    public void describe(Season s) {
        switch (s) {
            case Summer:
                System.out.println("Summer");
                break;
        }
    }

    public void describe2(int s) {
        //(2)得对输入值进行检查，确定是否越界，如果常量非常庞大，校验输入就成了一件非常麻烦的事情
        if (s >= 0 && s < 4) {
            switch (s) {
                case Season2.Summer:
                    System.out.println("Summer");
                    break;
            }
        }
    }
}

//(1)枚举常量更简单
enum Season {
    Spring, Summer, Autumn, Winter;

    //(4)枚举可以自定义方法(枚举常量不仅可以定义静态方法，还可以定义非静态方法，而且还能够从根本上杜绝常量类被实例化)
    //最舒服的季节
    public static Season getComfortableSeason() {
        return Spring;
    }

    public void say() {
        System.out.println("hello");
    }
}

interface Season2 {
    //(1)接口常量(或类常量)必须定义值，否则编译不通过，即使我们不需要关注其值是多少也必须定义
    int Spring = 0;
    int Summer = 1;
    int Autumn = 2;
    int Winter = 3;
}