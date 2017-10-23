package com.py.somesuggest.chapter5.no66;

import java.util.Arrays;
import java.util.List;

/**
 * asList方法产生的List对象不可更改
 * Created by Administrator on 2017/10/23 0023.
 */
//谨慎之戒之，除非非常自信该List只用于读操作
public class No66 {
    public static void main(String[] args) {
        //五天工作制
        Week[] workDays ={Week.Mon,Week.Tue,Week.Wed,Week.Thu,Week.Fir};
        //转换为列表
        /*
        asList返回的是一个长度不可变的列表，数组是多长,转换成的列表也就是多长
         */
        List<Week> list = Arrays.asList(workDays);
        //增加周六也为工作日
        list.add(Week.Sat);    //NOT DO THIS    Exception in thread "main" java.lang.UnsupportedOperationException
    }
}
enum Week{
    Sun,Mon,Tue,Wed,Thu,Fir,Sat
}
