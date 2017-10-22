package com.py.somesuggest.chapter3.no33;

/**
 * 不要覆写静态方法
 * Created by Administrator on 2017/9/21 0021.
 */
public class NO33 {
    public static void main(String[] args) {
        Base base = new Sub();
        //调用非静态方法
        base.doAnything();    //我是子类非静态方法
        //调用静态方法
        base.doSomething();    //我是父类静态方法
    }
}
class Base{
    //父类静态方法
    public static void doSomething(){
        System.out.println("我是父类静态方法");
    }
    //父类非静态方法
    public void doAnything(){
        System.out.println("我是父类非静态方法");
    }
}

class Sub extends Base{
    //子类同名、同参数的静态方法
    public static void doSomething(){
        System.out.println("我是子类静态方法");
    }
    //覆写父类的静态方法
    public void doAnything(){
        System.out.println("我是子类非静态方法");
    }
}