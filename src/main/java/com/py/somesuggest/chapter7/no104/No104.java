package com.py.somesuggest.chapter7.no104;

/**
 * 使用forName动态加载类文件
 * Created by Administrator on 2017/11/5 0005.
 * 注意：foeName只是加载类，并不执行任何代码。
 */
/*
加载一个类即表示要初始化该类的static变量，特别是static代码块，在这里我们可以做大量的工作，比如注册自己，初始化环境等。
如果没有static属性或static代码块，forName就只是加载类，没有任何的执行行为。
 */
public class No104 {
    public static void main(String[] args) throws ClassNotFoundException {
        //动态加载
        Class.forName("com.py.somesuggest.chapter7.no104.Utils");    //Do Something
    }
}
class Utils{
    //静态代码块
    static {
        System.out.println("Do Something");
    }
}
