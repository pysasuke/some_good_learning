package com.py.somesuggest.chapter10.no133;

/**
 * 若非必要，不要克隆对象
 * Created by Administrator on 2017/11/22 0022.
 * 注意：克隆对象并不比直接生成对象效率高
 */
public class No133 {
    private static class Apple implements Cloneable {
        public Object clone() {
            try {
                return super.clone();
            } catch (CloneNotSupportedException e) {
                throw new Error();
            }
        }
    }

    public static void main(String[] args) {
        //循环10万次
        final int maxLoops = 10 * 10000;
        int loops = 0;
        //开始时间
        long start = System.nanoTime();
        //"母"对象
        Apple apple = new Apple();
        while (++loops < maxLoops) {
            apple.clone();
        }
        long mid = System.nanoTime();
        System.out.println("clone方法生成对象耗时：" + (mid - start) + "ns");
        //new生成对象
        while (--loops > 0) {
            new Apple();
        }
        long end = System.nanoTime();
        System.out.println("new生成对象耗时：" + (end - mid) + "ns");
    }
}
/*
clone方法生成对象耗时：11069511ns
new生成对象耗时：2627798ns
 */