package com.py.somesuggest.chapter2;

import java.util.Scanner;

/**
 * 边界，边界，边界
 * Created by Administrator on 2017/9/16 0016.
 */
public class NO24 {
    //一个会员拥有产品的最多数量
    public final static int LIMIT = 2000;

    public static void main(String[] args) {
        //会员当前拥有的产品数量
        int cur = 1000;
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要预定的数量：");
        while (input.hasNext()) {
            int order = input.nextInt();
            //当前拥有的与准备订购的产品数量之和
            //缺少边界值校验
//            if (order > 0 && order + cur <= LIMIT) {  //当输入2147483647时，order+cur=-2147483649(因为超出int的范围)
//                System.out.println("你已经成功预定的" + order + "个产品");
//            } else {
//                System.out.println("超过限额，预定失败");
//            }

            //自己加的校验
            int after = order + cur;
            //当order + cur的值超过int范围时after为负数
            if (order > 0 && after > 0 && order + cur <= LIMIT) {  //当输入2147483647时，order+cur=-2147483649(因为超出int的范围)
                System.out.println("你已经成功预定的" + order + "个产品");
            } else {
                System.out.println("超过限额，预定失败");
            }
        }
    }
}
