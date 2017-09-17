package com.py.somesuggest.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * 堤防包装类型的null值
 * Created by Administrator on 2017/9/17 0017.
 */
//包装类型参与运算时，要做null值校验
public class NO26 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(null);
        System.out.println(count(list));
    }

    //计算list中所有元素之和
    public static int count(List<Integer> list) {
        int count = 0;
//        for (int i : list) {    //NOT DO THIS 当元素为null时会报空指针异常(拆箱过程是通过调用包装对象的intValue方法来实现)
//            count += i;
//        }
        for (Integer i : list) {
            count += (i != null) ? i : 0;
        }
        return count;
    }
}
