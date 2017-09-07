package com.py.somesummary.becareful;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pysasuke on 2017/7/25.
 * 尽量采用懒加载的策略，即在需要的时候才创建
 */
public class UseLazyLoading {
    public static void main(String[] args) {
        List list = new ArrayList<String>(10);
        int i = 1;
//        String str = "aaa"; //NOT DO THIS 如果i不等于1，则str是不需要被创建的
//        if (i == 1) {
//            list.add(str);
//        }
        if (i == 1) {
            String str = "aaa";
            list.add(str);
        }
    }
}
