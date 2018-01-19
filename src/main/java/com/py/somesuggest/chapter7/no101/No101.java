package com.py.somesuggest.chapter7.no101;

import java.util.ArrayList;

/**
 * 注意Class类的特殊性
 *
 * @author Administrator
 * @date 2017/11/5 0005
 */
/*
1.无构造函数
    Class对象是在加载类时由Java虚拟机通过调用类加载器中的defineClass方法自动构造的。
2.可以描述基本类型
    例如可以使用int.class表示int表示类型的类对象
3.其对象都是单例模式
    一个Class的实例可以描述一个类，并且只描述一个类，反过来也成立，一个类只有一个Class实例对象
 */
/*
一般获得一个Class对象有三种路径：
    类属性方式，如String.class
    对象的getClass方法，如new String().getClass()
    forName方法加载，如Class.forName("java.lang.String")
 */
public class No101 {
    public static void main(String[] args) {
        //类的属性class所引用的对象与实例对象的getClass返回值相同
        //true
        System.out.println(String.class.equals(new String("").getClass()));
        //true
        System.out.println("ABC".getClass().equals(String.class));
        //class实例对象不区分泛型
        //true
        System.out.println(ArrayList.class.equals(new ArrayList<String>().getClass()));
    }
}
