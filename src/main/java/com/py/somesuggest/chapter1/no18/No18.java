package com.py.somesuggest.chapter1.no18;

import java.util.Date;

/**
 * 避免instanceof非预期结果
 *
 * @author Administrator
 * @date 2017/9/16 0016
 */
public class No18 {
    public static void main(String[] args) {
        //String对象是否是Object的实例
        boolean b1 = "String" instanceof Object;
        //String对象是否是String的实例
        boolean b2 = new String() instanceof String;
        //Object对象是否是String的实例
        boolean b3 = new Object() instanceof String;
        //拆箱类型是否是装箱类型的实例
        //编译不通过：instanceof只能用于对象的判断，不能用于基本类型的判断
//        boolean b4 = 'A' instanceof Character;
        //空对象是否是String的实例
        //false  instanceof特有规则：若左边操作数是null，结果就直接返回false，不再运算右边操作数是什么类
        boolean b5 = null instanceof String;
        //类型转换后的空对象是否是String的实例
        //false    null是一个万用类型，也可以说它没有类型，即使做类型转换还是个null
        boolean b6 = (String) null instanceof String;
        //Date对象是否是String的实例
        //编译不通过    instanceof操作符的左右操作数必须有继承或者实现关系，否则编译会失败
//        boolean b7 = new Date() instanceof String;
        //在泛型类中判断String对象是否是Date的实例
        boolean b8 = new GenericClass<String>().isDateInstance("");
    }
}

class GenericClass<T> {
    /**
     * 判断是否是Date类型
     */
    public boolean isDateInstance(T t) {
        //泛型是为编码服务的，在编译成字节码时，T已经是Object类型了，
        //传递的实参是String类型，也就是说
        // T表面类型是Object，实际类型是String
        //所以编译通过，但返回的是false
        return t instanceof Date;
    }
}