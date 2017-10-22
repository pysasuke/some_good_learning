package com.py.somesuggest.chapter5.no60;

import java.util.List;

/**
 * 性能考虑，数组首选
 * Created by Administrator on 2017/10/22 0022.
 * 性能要求较高的场景中使用数组代替集合。
 */
//在实际测试中发现：对基本类型进行求和计算时，数组的效率是集合的10倍
public class No60 {

    public static int sumWithArray(int[] datas) {
        int sum = 0;
        int length = datas.length;
        for (int i = 0; i < length; i++) {
            /*
            这里其实已经做了一个拆箱动作，Integer对象通过intValue方法自动转换成了一个int基本类型
             */
            sum += datas[i];
        }
        return sum;
    }

    public static int sumWithList(List<Integer> datas) {
        int sum = 0;
        int size = datas.size();
        for (int i = 0; i < size; i++) {
            sum += datas.get(i);
        }
        return sum;
    }
}
