package com.py.somesuggest.chapter7.no97;

import java.util.ArrayList;
import java.util.List;

/**
 * 警惕泛型是不能协变和逆变的
 *
 * @author Administrator
 * @date 2017/11/4 0004
 * 注意：Java的泛型是不支持协变和逆变的，只是能够实现协变和逆变(使用通配符模拟)
 */
//协变是用一个窄类型替换宽类型，而逆变则是用宽类型覆盖窄类型。
public class No97 {
    public static void main(String[] args) {
        //数组支持协变
        Number[] n = new Integer[10];
        //编译不通过，泛型不支持协变:Java为了保证运行期的安全性，必须保证泛型参数类型是固定的，所以它不允许一个泛型参数可以同时包含两种类型，即使是父子类关系也不行。
//        List<Number> ln = new ArrayList<Integer>();    //NOT DO THIS
        List<? extends Number> ln = new ArrayList<Integer>();
        //泛型不支持逆变
        List<? super Integer> li = new ArrayList<Number>();
    }
}
