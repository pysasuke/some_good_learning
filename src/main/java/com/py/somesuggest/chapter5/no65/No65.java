package com.py.somesuggest.chapter5.no65;

import java.util.Arrays;
import java.util.List;

/**
 * 避开基本数据类型数组转换列表陷阱
 *
 * @author Administrator
 * @date 2017/10/23 0023
 */
public class No65 {
    public static void main(String[] args) {
//        int[] data = {1, 2, 3, 4, 5};
        Integer[] data = {1, 2, 3, 4, 5};
        /*
        asList方法输入的是一个泛型变长参数，8个基本类型不能作为泛型参数，数组是一个对象，它可以泛型化
         */
        List list = Arrays.asList(data);
        //列表中的元素数量是：1
        System.out.println("列表中的元素数量是：" + list.size());
        //元素类型：class [I
        System.out.println("元素类型：" + list.get(0).getClass());
        //前后是否相等：true
        System.out.println("前后是否相等：" + data.equals(list.get(0)));
    }
}
