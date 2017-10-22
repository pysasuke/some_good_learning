package com.py.somesuggest.chapter4.no52;

/**
 * 推荐使用String直接量赋值
 * Created by Administrator on 2017/10/21 0021.
 */
/*
字符串池：
   创建一个字符串时，首先检查池中是否有字面值相等的字符串，
   如果有，则不再创建，直接返回池中该对象的引用
   若没有则创建之，然后放到池里，并返回新创建对象的引用。
 */
/*
String类是一个不可变对象：
    一是String类是final类，不可继承，不可能产生一个String子类
    二是在String类提供的所有方法中，如果有String返回值，就会新建一个String对象，
    不对原对象进行修改，这也保证了元对象是不可改变的。
 */
public class No52 {
    public static void main(String[] args) {
        String str1 = "中国";
        String str2 = "中国";
        String str3 = new String("中国");
        String str4 = str3.intern();
        //两个直接量是否相等
        boolean b1 = (str1 == str2);
        //直接量和对象是否相等
        //直接声明一个String对象(new String)是不会检查字符串池的，也不会把对象放到池里
        boolean b2 = (str1 == str3);
        //经过intern处理后的对象与直接量是否相等
        //intern会检查当前的对象在对象池(自己理解：字符串池)中是否有字面值相同的引用对象，如果有则返回池中对象，如果没有则放置到对象池中，并返回当前对象
        boolean b3 = (str1 == str4);
        System.out.println(b1);    //true
        System.out.println(b2);    //false
        System.out.println(b3);    //true
    }
}
