package com.py.somesuggest.chapter1.no6;

/**
 * 覆写变长方法也要循规蹈矩
 * 注意：覆写的方法参数与父类相同，不仅仅是类型、数量，还包括形式
 *
 * @author Administrator
 * @date 2017/9/10 0010
 */
public class No6 {
    public static void main(String[] args) {
        //向上转型，形参列表由父类决定的
        Base base = new Sub();
        base.fun(100, 50);
        //不转型
        Sub sub = new Sub();
        //编译报错
//        sub.fun(100, 50);
    }
}

/**
 * 基类
 */
class Base {
    void fun(int price, int... discounts) {
        System.out.println("Base......fun");
    }
}

/**
 * 子类，覆写父类方法
 */
class Sub extends Base {
    //NOT DO THIS 覆写的方法参数列表与父类不同，会引发莫名其妙的问题
//    @Override
//    void fun(int price, int[] discounts) {
//        System.out.println("Sub......fun");
//    }
}

