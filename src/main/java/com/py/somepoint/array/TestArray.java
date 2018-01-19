package com.py.somepoint.array;

/**
 * @author pysasuke
 * @create 2017-09-05 15:02
 */
public class TestArray {

    public static void main(String[] args) {
        int[] array = new int[10];
        int[][] arrayOne = new int[10][10];
        int[][][] arrayTwo = new int[10][10][10];
        System.out.println("array的父类是：" + array.getClass().getSuperclass());
        //[I
        System.out.println("array的类名是：" + array.getClass().getName());
        //[[I
        System.out.println("二维数组：" + arrayOne.getClass().getName());
        //[[[I
        System.out.println("三维数组：" + arrayTwo.getClass().getName());
        //Object[]:class [Ljava.lang.Object;
        System.out.println("Object[]:" + Object[].class);
        //Object[][]:class [[Ljava.lang.Object;
        System.out.println("Object[][]:" + Object[][].class);
        //Object[][][]:class [[[Ljava.lang.Object;
        System.err.println("Object[][][]:" + Object[][][].class);
        //Object:class java.lang.Object
        System.out.println("Object:" + Object.class);

    }

}

