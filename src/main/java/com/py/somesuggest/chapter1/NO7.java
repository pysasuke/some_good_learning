package com.py.somesuggest.chapter1;

/**
 * 警惕自增陷阱
 * Created by Administrator on 2017/9/10 0010.
 */
public class NO7 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i < 10; i++) {
//            count = count++;    //NOT DO THIS  与mockAdd方法是一样的
//            count = mockAdd(count);
            count++;
        }
        System.out.println("count=" + count);    //0
    }

    public static int mockAdd(int count) {
        //先保存初始值
        int temp = count;
        //做自增操作
        count = count + 1;
        //返回原始值
        return temp;
    }
}

