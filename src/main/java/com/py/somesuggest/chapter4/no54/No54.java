package com.py.somesuggest.chapter4.no54;

/**
 * 正确使用String、StringBuffer、StringBuilder
 * Created by Administrator on 2017/10/22 0022.
 * 注意：在适当的场景选用字符串类型
 */
/*
CharSequence接口有三个实现类与字符串有关：String、StringBuffer、StringBuilder

StringBuilder与StringBuffer基本相同，都是可变字符序列，
不同点是：StringBuffer是线程安全的，StringBuilder是线程不安全的，
StringBuffer的方法前都有synchronized关键字，这也是StringBuffer在性能上远低于StringBuilder的原因。

三者使用场景：
1、使用String类的场景
    在字符串不经常变化的场景中可以使用String类，例如常量的声明、少量的变量运算等。
2、使用StringBuffer类的场景
    在频繁进行字符串的运算(如拼接、替换、删除等)，并且运行在多线程的环境中，
    则可以考虑使用StringBuffer，例如XML解析、HTTP参数解析和封装等。
3、使用StringBuilder类的场景
    在频繁进行字符串的运算(如拼接、替换、删除等)，并且运行在单线程的环境中，
    则可以考虑使用StringBuilder，如SQL语句的拼装、JSON封装等。
 */
public class No54 {
}
