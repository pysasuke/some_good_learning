package com.py.somepoint.array;

import java.util.Arrays;

/**
 * @author pysasuke
 * @create 2017-09-05 15:35
 */
public class ArrayUtils {
    /**
     * @desc 对数组进行扩容
     * @author chenssy
     * @data 2013-12-8
     * @param <T>
     * @param datas 原始数组
     * @param newLen 扩容大小
     * @return T[]
     */
    public static <T> T[] expandCapacity(T[] datas, int newLen) {
        newLen = newLen < 0 ? datas.length : datas.length + newLen; /*生成一个新的数组*/
        return Arrays.copyOf(datas, newLen);
    }

    /**
     * @desc 对数组进行扩容处理，1.5倍
     * @author chenssy
     * @data 2013-12-8
     * @param <T>
     * @param datas  原始数组
     * @return T[]
     */
    public static <T> T[] expandCapacity(T[] datas) {
        /*扩容原始数组的1.5倍*/
        int newLen = (datas.length * 3) / 2;
        //生成一个新的数组
        return Arrays.copyOf(datas, newLen);
    }

    /**
     * @desc 对数组进行扩容处理，
     * @author chenssy
     * @data 2013-12-8
     * @param <T>
     * @param datas 原始数组
     * @param mulitiple 扩容的倍数
     * @return T[]
     */
    public static <T> T[] expandCapacityMul(T[] datas, int mulitiple) {
        mulitiple = mulitiple < 0 ? 1 : mulitiple;
        int newLen = datas.length * mulitiple;
        return Arrays.copyOf(datas, newLen);
    }
}
