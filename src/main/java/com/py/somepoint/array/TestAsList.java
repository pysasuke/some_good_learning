package com.py.somepoint.array;

import java.util.Arrays;
import java.util.List;

/**
 * @author pysasuke
 * @create 2017-09-05 15:50
 */
public class TestAsList {
    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 4, 5};
        List list = Arrays.asList(data);
        //1
        System.out.println(list.size());
        //[I@4554617c 整个数组作为一个对象放入list中了
        System.out.println(list.get(0));
    }
}
