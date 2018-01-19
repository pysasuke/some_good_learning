package com.py.somesuggest.chapter1.no10;

import static java.lang.Math.PI;
import static java.lang.Math.abs;
/**
 *
 * @author Administrator
 * @date 2017/9/10 0010
 */
public class No10_2 {
    //常量名与静态导入的PI相同
//    public final static String PI = "祖冲之";    //NOT DO THIS 若果要变更一个被静态导入的方法，最好的办法是在原始类中重构，而不是在本类中覆盖
    //方法名与静态导入的相同
//    public static int abs(int abs) {    //NOT DO THIS
//        return 0;
//    }

    public static void main(String[] args) {
        /*
        编译器有一个"最短路径"原则：
            如果能够在本类中查找到的变量、常量、方法，就不会
        到其他包或者父类、接口中查找，以确保类中的属性、方法优先。
         */
        //PI祖冲之
        System.out.println("PI" + PI);
        //abs(100)=0
        System.out.println("abs(100)=" + abs(-100));
    }
}
