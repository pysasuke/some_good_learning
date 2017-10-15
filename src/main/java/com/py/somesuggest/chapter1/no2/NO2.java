package com.py.somesuggest.chapter1.no2;

/**
 * 莫让常量蜕变成变量
 * 注意：务必让常量的值在运行期保持不变
 * Created by Administrator on 2017/9/10 0010.
 */
public class NO2 {
    public static void main(String[] args) {
        System.out.println("常量会变哦：" + Const.RAND_CONST);
    }

    interface Const {
        //        public static final int RAND_CONST = new Random().nextInt();    //NOT DO THIS 常量就是常量，在编译期就必须确定其值，不应该在运行期更改
        public static final int RAND_CONST = 1;
    }
}
