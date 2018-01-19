package com.py.somesuggest.chapter7.no93;

import java.util.ArrayList;
import java.util.List;

/**
 * Java的泛型是类型擦除的
 *
 * @author Administrator
 * @date 2017/11/4 0004
 */
/*
编译后所以的泛型类型都会做相应的转换，转换规则如下：
    List<String>、List<Integer>、List<T>擦除后的类型为List。
    List<String>[] 擦除后的类型为List[].
    List<? extends E>、List<? super E>擦除后的类型为List<E>。
    List<T extends Serializable & Cloneable>擦除后为List<Serializable>。
 */
public class No93 {
    /**
     * arrayMethod接收数组参数，并进行重载
     * @param strArray
     */
    public void arrayMethod(String[] strArray) {
    }

    public void arrayMethod(Integer[] strArray) {
    }

    //listMethod接收泛型List参数，并进行重载
    public void listMethod(List<String> stringList) {
    }

    //NOT DO THIS    无法编译
    /*
     该方法在编译时擦除类型后的方法就是ListMethod(List<E>),
     他与另一个方法重复，通俗地说就是方法签名重复。
     */
//    public void listMethod(List<Integer> integerList) {
//    }
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abc");
        String str = list.get(0);
        /*编译后
        List list = new ArrayList();
        list.add("abc");
        String str = (String) list.get(0);
         */
        //(1)泛型的class对象是相同的：List<String>和List<Integer>擦除后的类型都是List,没有任何区别。
        List<String> ls = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        //true
        System.out.println(li.getClass() == ls.getClass());
        //(2)泛型数组初始化时不能声明泛型类型：可以声明一个带泛型参数的数组，但是不能初始化该数组，因为执行了类型擦除操作，List<Object>[] 与List<String>[]就是同一回事了，编译器拒绝如此声明。
        //(3)instanceof不允许存在泛型参数：不能通过编译，原因也是泛型类型被擦除了。
//        System.out.println(ls instanceof List<String>);    //NOT DO THIS
    }
}
