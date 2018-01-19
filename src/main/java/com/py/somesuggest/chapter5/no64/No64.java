package com.py.somesuggest.chapter5.no64;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * 多种最值算法，适时选择
 *
 * @author Administrator
 * @date 2017/10/23 0023
 * 注意：最值计算时使用集合最简单，使用数组性能最优
 */
public class No64 {

    /**
     * 自行实现，快速查找最大值
     */
    public static int max1(int[] data) {
        int max = data[0];
        for (int i : data) {
            max = max > i ? max : i;
        }
        return max;
    }

    /**
     * 先排序，后取值
     * @param data
     * @return
     */
    public static int max2(int[] data) {
        //先排序
        /*
        之所以先使用data.clone拷贝再排序,是因为数组也是一个对象，不拷贝会改变原有数组元素的顺序
         */
        Arrays.sort(data.clone());
        //然后取值
        return data[data.length - 1];
    }

    /**
     * 先剔除重复数据，然后再排序
     * @param data
     * @return
     */
    public static int getSecond(Integer[] data) {
        //转换为列表
        List<Integer> dataList = Arrays.asList(data);
        //转换为TreeSet，删除重复元素并升序排列
        TreeSet<Integer> treeSet = new TreeSet<>(dataList);
        //取得比最大值小的最大值，也就是第二大的值
        return treeSet.lower(treeSet.last());
    }
}
