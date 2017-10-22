package com.py.somesuggest.chapter3.no37;

/**
 * 构造代码块会想你所想
 * Created by Administrator on 2017/10/9 0009.
 */
//如果遇到this关键字(也就是构造函数调用其自身其他的构造函数时)则不插入构造代码块
public class NO37 {
    public static void main(String[] args) {
        new Count();
        new Count("");
        new Count(0);
        System.out.println("实例对象数量：" + Count.getNumberOfObjects());    //实例对象数量：3
    }
}

class Count {
    //对象计数器
    private static int numOfObjects = 0;

    {
        //构造代码块，计算产生对象数量
        numOfObjects++;
    }

    public Count() {
    }

    //有参构造函数调用无参构造函数
    public Count(String str) {
        this();
    }

    //有参构造函数不调用其他构造函数
    public Count(int i) {

    }

    public static int getNumberOfObjects() {
        return numOfObjects;
    }
}
