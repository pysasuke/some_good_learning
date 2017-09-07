package com.py.somesummary.difficultcheck;

import java.util.ArrayList;
import java.util.List;

/**
 * 两个花括号初始化常量集合相关
 * @author pysasuke
 * @create 2017-09-05 17:34
 */
public class InitList {
    //初始化常量集合的简便语法
    //但是利用两个花括号进行初始化是有另一套初始化过程的。
    //这里，我们用了一个匿名类来初始化一个List，当要打印NAMES时，实际上打印出来的是null，
    //这是因为初始化程序尚未完成，此时的list是空的。
    private static final List<String> NAMES =new ArrayList<String>(){{
        add("John");
        System.out.println(NAMES);//null
    }};

    public static void main(String[] args) {
        System.out.println(NAMES);//[John]
    }
}
