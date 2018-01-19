package com.py.somesummary.becareful;

/**
 * Created by pysasuke on 2017/7/25.
 * 三种转String方法比较
 */
/*
1、String.valueOf()方法底层调用了Integer.toString()方法，但是会在调用前做空判断

2、Integer.toString()方法就不说了，直接调用了

3、i + “”底层使用了StringBuilder实现，先用append方法拼接，再用toString()方法获取字符串

三者对比下来，明显是2最快、1次之、3最慢
 */
public class ChangeToString {
    public static void main(String[] args)
    {
        int loopTime = 50000;
        Integer i = 0;
        long startTime = System.currentTimeMillis();
        for (int j = 0; j < loopTime; j++)
        {
            String str = String.valueOf(i);
        }
        System.out.println("String.valueOf()：" + (System.currentTimeMillis() - startTime) + "ms");
        startTime = System.currentTimeMillis();
        for (int j = 0; j < loopTime; j++)
        {
            //最快
            String str = i.toString();
        }
        System.out.println("Integer.toString()：" + (System.currentTimeMillis() - startTime) + "ms");
        startTime = System.currentTimeMillis();
        for (int j = 0; j < loopTime; j++)
        {
            String str = i + "";
        }
        System.out.println("i + \"\"：" + (System.currentTimeMillis() - startTime) + "ms");
    }
    /*
    String.valueOf()：6ms
    Integer.toString()：3ms
    i + ""：13ms
     */
}
