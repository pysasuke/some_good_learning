package com.py.somesuggest.chapter7.no106;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/11/7 0007.
 */
/*
这里没有了代理主题角色，取而代之的是SubjectHander作为主要的逻辑委托处理，
其中invoke方法是接口InvocationHandler定义必须实现的，它完成了对真实方法的调用。
 */

public class Dynamic {
    public static void main(String[] args) {
        //具体主题角色，也就是被代理类
        Subject2 subject2 = new RealSubject2();
        //代理实例的处理Handler
        InvocationHandler handler = new SubjectHandler(subject2);
        //当前加载器
        ClassLoader c1 = subject2.getClass().getClassLoader();
        //动态代理
        Subject2 proxy = (Subject2) java.lang.reflect.Proxy.newProxyInstance(c1, subject2.getClass().getInterfaces(), handler);
        proxy.request();
    }
}

//抽象主题角色
interface Subject2 {
    //定义一个方法
    public void request();
}

//具体主题角色
class RealSubject2 implements Subject2 {
    //实现方法
    @Override
    public void request() {
        //业务逻辑处理
    }
}

class SubjectHandler implements InvocationHandler {
    //被代理的对象
    private Subject2 subject2;

    public SubjectHandler(Subject2 _subject2) {
        subject2 = _subject2;
    }

    //委托处理方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //预处理
        System.out.println("预处理");
        Object obj = method.invoke(subject2, args);
        System.out.println("后处理");
        return obj;
    }
}