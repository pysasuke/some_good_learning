package com.py.somesuggest.chapter9.no121;

/**
 * 线程优先级只使用三个等级
 * Created by Administrator on 2017/11/14 0014.
 * 注意：线程优先级推荐使用MIN_PRIORITY、NORM_PRIORITY、MAX_PRIORITY三个级别，不建议使用其他7个数字。
 */
/*
Java的优先级只是代表抢占CPU的机会大小，优先级越高，抢占CPU的机会越大，
被有限执行的可能性越高，优先级相差不大，则抢占CPU的机会差别也不大。
 */
public class No121 {
    public static void main(String[] args) {
        //启动20个不同优先级的线程
        for (int i = 0; i < 20; i++) {
            new TestThread().start(i % 10 + 1);
        }
    }
}

class TestThread implements Runnable {
    //启动线程
    public void start(int _priority) {
        Thread t = new Thread(this);
        t.setPriority(_priority);
        t.start();
    }

    @Override
    public void run() {
        //消耗CPU的计算
        for (int i = 0; i < 100000; i++) {
            Math.hypot(Math.pow(924526789, i), Math.cos(i));
        }
        //输出线程优先级
        System.out.println("Priority:" + Thread.currentThread().getPriority());
    }
}
/*
Priority:9
Priority:9
Priority:10
Priority:10
Priority:8
Priority:7
Priority:7
Priority:8
Priority:5
Priority:6
Priority:5
Priority:6
Priority:3
Priority:4
Priority:4
Priority:3
Priority:2
Priority:2
Priority:1
Priority:1
 */