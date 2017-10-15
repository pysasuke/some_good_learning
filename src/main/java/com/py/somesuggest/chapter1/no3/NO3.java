package com.py.somesuggest.chapter1.no3;

/**
 * 三元操作符的类型务必一致
 * Created by Administrator on 2017/9/10 0010.
 */
public class NO3 {
    public static void main(String[] args) {
        int i = 80;
        /*
        三元操作符类型的转换规则：
            若两个操作数不可转换，则不做转换，返回值为Object类型。
            若两个操作数是明确类型的表达式(比如变量)，则按照正常的二进制数字来转换，
        int类型转换为long类型，long类型转换为float类型等。
            若两个操作数中有一个数字S，另外一个是表达式，且其类型标示为T，那么，若
        数字S在T的范围内，则转换为T类型；若S超出T类型的范围，则T转换为S类型。
            若两个操作数都是直接量数字，则返回值类型为范围较大者。
         */
        String s = String.valueOf(i < 100 ? 90 : 100);
        String s1 = String.valueOf(i < 100 ? 90 : 100.0);    //90.0     NOT DO THIS
        System.out.println("两者是否相等：" + s.equals(s1));    //false
    }
}
