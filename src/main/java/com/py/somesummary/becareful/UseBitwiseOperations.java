package com.py.somesummary.becareful;

/**
 * Created by pysasuke on 2017/7/25.
 * 乘法和除法使用移位操作
 */
public class UseBitwiseOperations {
    public static void main(String[] args) {
        int a,b;
        for (int val = 0; val < 100000; val += 5)
        {
//            a = val * 8;  //NOT DO THIS  用移位操作可以极大地提高性能，因为在计算机底层，对位的操作是最方便、最快的
//            b = val / 2;
            a = val << 3;
            b = val >> 1;
        }
    }
}
