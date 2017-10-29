package com.py.somesuggest.chapter5.no74;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 不推荐使用binarySearch对列表进行检索
 * Created by Administrator on 2017/10/29 0029.
 * 注意：从性能方面考虑，binarySearch是最好的选择。
 */
/*
二分法查询的一个首要前提是：数据集已经实现升序排列，否则二分法查找的值是不准确的。
 */
public class No74 {
    public static void main(String[] args) {
        List<String> cities = new ArrayList<>();
        cities.add("上海");
        cities.add("广州");
        cities.add("广州");
        cities.add("北京");
        cities.add("天津");
        //indexOf方法取得索引值
        int index1 =cities.indexOf("广州");
        //binarySearch查找到索引值
        int index2 = Collections.binarySearch(cities, "广州");
        System.out.println("索引值(indexOf):"+index1);    //索引值(indexOf):1
        System.out.println("索引值(binarySearch):"+index2);    //索引值(binarySearch):2
    }
}
