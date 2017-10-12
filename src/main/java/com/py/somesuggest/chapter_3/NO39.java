package com.py.somesuggest.chapter_3;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用匿名类的构造函数
 * Created by Administrator on 2017/10/11 0011.
 */
public class NO39 {
    public static void main(String[] args) {
        List l1 = new ArrayList();    //声明了ArrayList的实例对象
        List l2 = new ArrayList() {};
        /*
        l2代表的是一个匿名类的声明和赋值，它定义了一个继承与ArrayList的匿名类
        只是没有任何的覆写方法而已，其代码类似于：
        //定义一个继承ArrayList的内部类
        class Sub extends ArrayList{
        }
        //声明和赋值
        List l2 = new Sub();
         */
        List l3 = new ArrayList() {{}};
        /*
        这也是一个匿名类的定义，它的代码类似于：
        //定义一个继承ArrayList的内部类
        class Sub extends ArrayList{
            {
                //c初始化块
             }
        }
        //声明和赋值
        List l3 = new Sub();
         */
        System.out.println(l1.getClass() == l2.getClass());    //false
        System.out.println(l2.getClass() == l3.getClass());    //false
        System.out.println(l1.getClass() == l3.getClass());    //false
        System.out.println(l1.getClass());    //class java.util.ArrayList
        System.out.println(l2.getClass());    //class com.py.somesuggest.chapter_3.NO39$1
        System.out.println(l3.getClass());    //class com.py.somesuggest.chapter_3.NO39$2
    }
}
