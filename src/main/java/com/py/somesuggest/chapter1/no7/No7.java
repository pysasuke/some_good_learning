package com.py.somesuggest.chapter1.no7;

/**
 * 警惕自增陷阱
 *
 * @author Administrator
 * @date 2017/9/10 0010
 */
public class No7 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i < 10; i++) {
            //NOT DO THIS  与mockAdd方法是一样的
//            count = count++;
//            count = mockAdd(count);
            count++;
        }
        //0
        System.out.println("count=" + count);
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

