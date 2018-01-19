package com.py.somesuggest.chapter7.no106;

/**
 *
 * @author Administrator
 * @date 2017/11/7 0007
 */
/*
静态代理是通过代理主题角色(Proxy)和具体主题角色(Real Subject)共同实现抽象主题角色(Subject)的逻辑，
只是代理主题角色把相关的执行逻辑委托给了具体主题角色而已
*/
public class Static {
}

/**
 * 抽象主题角色
 */
interface Subject {
    /**
     * 定义一个方法
     */
    public void request();
}

/**
 * 具体主题角色
 */
class RealSubject implements Subject {
    //实现方法
    @Override
    public void request() {
        //业务逻辑处理
    }
}

/**
 * 代理主题角色
 */
class Proxy implements Subject{
    /**
     * 要代理哪个实现类
     */
    private Subject subject =null;

    /**
     * 默认被代理者
     */
    public Proxy(){
        subject = new RealSubject();
    }

    /**
     * 通过构造函数传递被代理者
     * @param subject
     */
    public Proxy(Subject subject){
        this.subject = subject;
    }

    //实现接口中定义的方法
    @Override
    public void request() {
        before();
        subject.request();
        after();
    }

    /**
     * 预处理
     */
    private void before(){
        //do something
    }

    /**
     * 善后处理
     */
    private void after(){
        //do something
    }
}
