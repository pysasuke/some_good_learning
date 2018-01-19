package com.py.somesuggest.chapter7.no95;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 强制声明泛型的实际类型
 *
 * @author Administrator
 * @date 2017/11/4 0004
 */
//无法从代码中推断出泛型类型的情况下，即可强制声明泛型类型。
public class No95 {
    //正常用法
    List<String> list1 = ArrayUtils.asList("A", "B");
    //参数为空
    //编译器会推断出顶层类Object就是其泛型类型
    List list2 = ArrayUtils.asList();
    //完整定义如下：
    //List<Object> list2 =ArrayUtils.asList();
    //希望：List<Integer> list2 =ArrayUtils.<Integer>asList();
    //参数为整数类型和浮点类型的混合
    //当发现多个元素的实际类型不一致时就会直接确认泛型类型是Object，而不会去追索元素类的公共父类是什么
    List list3 = ArrayUtils.asList(1, 2, 3.1);
    //希望：List<Number> list3 = ArrayUtils.<Number>asList(1, 2, 3.1);
}

class ArrayUtils {
    /**
     * 把一个变长参数转为列表，并且长度可变
     * @param t
     * @param <T>
     * @return
     */
    public static <T> List<T> asList(T... t) {
        List<T> list = new ArrayList<T>();
        Collections.addAll(list, t);
        return list;
    }
}