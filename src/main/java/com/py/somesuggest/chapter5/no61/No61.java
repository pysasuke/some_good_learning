package com.py.somesuggest.chapter5.no61;

import java.util.Arrays;

/**
 * 若有必要，使用变长数组
 * Created by Administrator on 2017/10/22 0022.
 */
public class No61 {

    public static void main(String[] args) {
        //一个班级最多容量60个学生
        Stu[] classes = new Stu[60];
        /*classes初始化*/
        classes = expandCapacity(classes, 80);
        /*重新初始化超过限额的20人*/
    }

    public static <T> T[] expandCapacity(T[] datas, int newLen) {
        //不能是负值
        newLen = newLen < 0 ? 0 : newLen;
        return Arrays.copyOf(datas, newLen);
    }
}

class Stu {

}


