package com.py.somepoint.array;

/**
 * @author pysasuke
 * @create 2017-09-05 15:02
 */
public class TestArray {

    public static void main(String[] args) {
        int[] array = new int[10];
        int[][] array_01 = new int[10][10];
        int[][][] array_02 = new int[10][10][10];
        System.out.println("array的父类是：" + array.getClass().getSuperclass());
        System.out.println("array的类名是：" + array.getClass().getName());    //[I
        System.out.println("二维数组：" + array_01.getClass().getName());    //[[I
        System.out.println("三维数组：" + array_02.getClass().getName());    //[[[I
        System.out.println("Object[]:" + Object[].class);    //Object[]:class [Ljava.lang.Object;
        System.out.println("Object[][]:" + Object[][].class);    //Object[][]:class [[Ljava.lang.Object;
        System.err.println("Object[][][]:" + Object[][][].class);    //Object[][][]:class [[[Ljava.lang.Object;
        System.out.println("Object:" + Object.class);    //Object:class java.lang.Object

    }

}

