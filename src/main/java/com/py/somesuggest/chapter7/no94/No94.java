package com.py.somesuggest.chapter7.no94;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 不能初始化泛型参数的数组
 * Created by Administrator on 2017/11/4 0004.
 */
public class No94 {
}

class Foo<T> {
    //    private T t = new T();    //NOT DO THIS    编译不通过，因为编译器在编译时需要获得T类型，但泛型在编译器类型已经被擦出了。
//    private T[] tArray = new T[5];    //NOT DO THIS
    private List<T> list = new ArrayList<>();    //编译通过：因为ArrayList表面是泛型，其实已经在编译期转型为Object了
}

class Foo2<T> {
    //不再初始化，由构造函数初始化
    private T t;
    private T[] tArray;
    private List<T> list = new ArrayList<>();

    //一般情况下泛型类型(tType)是无法获取的，不过，在客户端调用时多传输一个T类型的class就会解决问题。
    // 类的成员变量是在初始化前初始化的，所以要求在初始化前它必须具有明确的类型，否则就只能声明，不能初始化
    //构造函数初始化
    public Foo2() {
        try {
            Class<?> tType = Class.forName("");
            t = (T) tType.newInstance();
            tArray = (T[]) Array.newInstance(tType, 5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}