package com.py.somesummary.becareful;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pysasuke on 2017/7/25.
 * 尽量减少对变量的重复计算
 */
public class ReduceRepeatedCalculation {
    public static void main(String[] args) {
        List list = new ArrayList<String>(10);
//        for (int i = 0; i < list.size(); i++) { //NOT DO THIS list.size()会反复计算
//        }
        for (int i = 0, length = list.size(); i < length; i++) {
        }
    }
}
