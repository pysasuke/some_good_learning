package com.py.somesuggest.chapter5.no69;

import java.util.ArrayList;
import java.util.Vector;

/**
 * 列表相等只需关心元素
 * Created by Administrator on 2017/10/25 0025.
 * 注意：判断集合是否相等时只需关注元素是否相等即可
 */
public class No69 {
    public static void main(String[] args) {
        ArrayList<String> strs = new ArrayList<>();
        strs.add("A");
        Vector<String> strs2 = new Vector<>();
        strs2.add("A");
        System.out.println(strs.equals(strs2));    //true
    }
}
