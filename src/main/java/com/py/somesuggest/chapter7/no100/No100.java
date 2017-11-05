package com.py.somesuggest.chapter7.no100;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * 数组的真实类型必须是泛型类型的子类型
 * Created by Administrator on 2017/11/5 0005.
 */
public class No100 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "B");
//        for (String str : toArray(list)) {
//            System.out.println(str);    //Exception in thread "main" java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.String;
//        }
        for (String str : toArray2(list,String.class)) {
            System.out.println(str);
        }
    }
    //当一个泛型类(特别是泛型集合)转变为泛型数组时，泛型数组的真实类型不能是泛型类型的父类型(比如顶层类Object),只能是泛型类型的子类型(当然包括自身类型)，否则就会出现类型转换异常。
    public static <T> T[] toArray(List<T> list) {
        T[] t = (T[]) new Object[list.size()];
        for (int i = 0, n = list.size(); i < n; i++) {
            t[i] = list.get(i);
        }
        return t;
    }
    public static <T> T[] toArray2(List<T> list, Class<T> tClass) {
        //声明并初始化一个T类型的数组
        T[] t = (T[]) Array.newInstance(tClass, list.size());
        for (int i = 0, n = list.size(); i < n; i++) {
            t[i] = list.get(i);
        }
        return t;
    }
}
