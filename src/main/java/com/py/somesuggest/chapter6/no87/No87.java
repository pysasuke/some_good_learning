package com.py.somesuggest.chapter6.no87;

import java.util.Arrays;
import java.util.List;

/**
 * 使用valueOf前必须进行校验
 *
 * @author Administrator
 * @date 2017/10/31 0031
 */
/*
valueOf方法会把一个String类型的名称转变为枚举项，也就是在枚举项中查找字面值与该参数相等的枚举项。
valueOf方法先通过反射从枚举类的常量声明中查找，若找到就直接返回，若找不到则抛出无效参数异常。
 */
public class No87 {
    public static void main(String[] args) {
        //注意summer是小写
        List<String> params = Arrays.asList("Spring", "summer");
        for (String name : params) {
            //查找字面值与name相同的枚举项
            if (Season.contains(name)) {
                //Exception in thread "main" java.lang.IllegalArgumentException: No enum constant com.py.somesuggest.chapter6.no87.Season.summer
                Season s = Season.valueOf(name);
                if (s != null) {
                    //有该枚举值
                    System.out.println(s);
                } else {
                    //没有该枚举值
                    System.out.println("无相关枚举项");
                }
            }

            //(1)使用try-catch捕捉异常
            /*
            try {
                Season s = Season.valueOf(name);
                System.out.println(s);
            } catch (IllegalArgumentException e) {
                System.out.println("无相关枚举项");
            }
            */
        }
    }
}

enum Season {
    Spring, Summner, Autumn, Winter;

    //(2)扩展枚举类
    //是否包含指定名称的枚举项
    public static boolean contains(String name) {
        //所有的枚举值
        Season[] seasons = values();
        //遍历查找
        for (Season s : seasons) {
            if (s.name().equals(name)) {
                return true;
            }
        }
        return false;
    }
}