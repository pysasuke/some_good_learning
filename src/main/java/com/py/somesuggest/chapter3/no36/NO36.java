package com.py.somesuggest.chapter3.no36;

/**
 * 使用构造代码块精炼程序
 * Created by Administrator on 2017/10/9 0009.
 */
/*
Java中一共有四种类型的代码块：
1.普通代码块：
    就是在方法后面使用"{}"括起来的代码片段，它不能单独执行，必须通过方法名调用执行
2.静态代码块
    在类中使用static修饰，并使用"{}"括起来的代码片段，用于静态变量的初始化或对象创建前的环境初始化
3.同步代码块
    使用synchronized关键字修饰，并使用"{}"括起来的代码片段，它标识同一时间只能有一个线程进入到该方法块中，是一种多线程保护机制
4.构造代码块
    再类中没有任何的前缀或后缀，并使用"{}"括起来的代码片段
 */

//编译器会把构造代码块插入到每个构造函数的最前端
//需要注意的是：构造代码块不是在构造函数之前运行的，它依托于构造函数的执行
//如果遇到this关键字(也就是构造函数调用其自身其他的构造函数时)则不插入构造代码块
public class NO36 {
    {
        System.out.println("执行构造代码块");
    }

    public NO36() {
//        System.out.println("执行构造代码块");
        System.out.println("执行无参构造函数");
    }

    public NO36(String str) {
//        System.out.println("执行构造代码块");
        System.out.println("执行有残构造函数");
    }
}
