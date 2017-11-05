package com.py.somesuggest.chapter6.no92;

/**
 * 注意@Override不同版本的区别
 * Created by Administrator on 2017/11/3 0003.
 */
/*
1.5版中@Override是严格尊重覆写的定义：
    子类方法与父类方法必须具有相同的方法名、输入参数、输出参数(允许子类缩小)、访问权限(允许子类扩大)，
    父类必须是一个类，不能是一个接口，否则不能算是覆写。
1.6就开放多了：
    实现接口的方法也可以加上@Override注解了，可以避免粗心大意导致方法名称与接口不一致的情况发生。
如果是Java1.6版本的程序移植到1.5版本环境中，就需要删除实现接口方法上的@Override注解。
 */
public class No92 {
}

interface Foo {
    public void doSomething();
}

class Impl implements Foo {

    @Override
    public void doSomething() {

    }
}