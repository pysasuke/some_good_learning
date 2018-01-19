package com.py.somesuggest.chapter9.no129;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 适当设置阻塞队列长度
 *
 * @author Administrator
 * @date 2017/11/20 0020
 * 注意：阻塞队列的长度是固定的。
 */
/*
阻塞队列的容量是固定的，非阻塞队列则是变长的。阻塞队列可以在声明时指定队列的容量，若指定容量，则元素的数量不可超过该容量，若不指定，队列的容量为Integer的最大值
 */
public class No129 {
    public static void main(String[] args) {
        //定义初始长度为5
        BlockingQueue<String> bq = new ArrayBlockingQueue<>(5);
        //加入10个元素
        for (int i = 0; i < 10; i++) {
            //Exception in thread "main" java.lang.IllegalStateException: Queue full
            bq.add("");
        }
    }
}
