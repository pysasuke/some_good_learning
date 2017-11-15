package com.py.somesuggest.chapter9.no125;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 优先选择线程池
 * Created by Administrator on 2017/11/15 0015.
 */
public class No125 {
    public static void main(String[] args) {
        //2个线程的线程池
        ExecutorService es = Executors.newFixedThreadPool(2);
        //多次执行线程体
        for (int i = 0; i < 4; i++) {
            es.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        //关闭执行器
        es.shutdown();
    }
}
/*
pool-1-thread-2
pool-1-thread-1
pool-1-thread-1
pool-1-thread-2
 */