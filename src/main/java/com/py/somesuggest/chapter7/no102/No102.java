package com.py.somesuggest.chapter7.no102;

import java.lang.reflect.Method;

/**
 * 适时选择getDeclaredXXX和getXXX
 * Created by Administrator on 2017/11/5 0005.
 */
/*
getMethod方法获得的是所以public访问级别的方法，包括从父类继承的方法
getDeclareMethod方法获得的是自身类的所有方法，包括public、private方法，而且不受限于访问权限
 */
public class No102 {
    public static void main(String[] args) throws NoSuchMethodException {
        //方法名称
        String methodName = "doStuff";
        Method m1 = Foo.class.getDeclaredMethod(methodName);
        Method m2 = Foo.class.getMethod(methodName);    //Exception in thread "main" java.lang.NoSuchMethodException: com.py.somesuggest.chapter7.no102.No102$Foo.doStuff()
    }
    //静态内部类
    static class Foo{
        void doStuff(){}
    }
}
