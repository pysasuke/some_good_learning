package com.py.somesuggest.chapter7.no96;

import java.util.List;

/**
 * 不同的场景使用不同的泛型通配符
 *
 * @author Administrator
 * @date 2017/11/4 0004
 */
public class No96 {
    //(1)泛型结构只参与“读”操作则限定上界(extends关键值)
    public static <E> void read(List<? extends E> list) {
        for (E e : list) {
            //业务逻辑操作
        }
    }

    //(2)泛型结构只参与“写”操作则界定下界(使用super关键字)
    public static void write(List<? super Number> list) {
        list.add(123);
    }
    //(3)如果一个泛型结构既用作“读”操作又用作“写”操作，则不限定，使用确定的泛型类型即可，如List<E>。
}
