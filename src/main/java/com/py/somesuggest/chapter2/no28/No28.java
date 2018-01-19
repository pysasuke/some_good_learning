package com.py.somesuggest.chapter2.no28;

import java.util.Scanner;

/**
 * 优先使用整型池
 * 注意：通过包装类的valueOf生成包装实例可以显著提高空间和时间性能
 *
 * @author Administrator
 * @date 2017/9/18 0018
 */
public class No28 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int ii = input.nextInt();
            System.out.println("\n====" + ii + "的相等判断======");
            Integer i = new Integer(ii);
            Integer j = new Integer(ii);
            System.out.println("new产生的对象：" + (i == j));
            //基本类型转为包装类型后比较
            //装箱动作是通过valueOf方法实现的
            i = ii;
            j = ii;
            System.out.println("基本类型转换的对象：" + (i == j));
            //通过静态方法生成一个实例
            //通过valueOf产生包装对象时，如果int参数在-128和127之间，则直接从整型池中获得对象，
            // 不在该范围的int类型则通过new生成包装对象
            i = Integer.valueOf(ii);
            j = Integer.valueOf(ii);
            System.out.println("valueOf产生的对象：" + (i == j));
        }
    }
}
