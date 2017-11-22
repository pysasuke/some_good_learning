package com.py.somesuggest.chapter9.no131;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier让多线程齐步走
 * Created by Administrator on 2017/11/21 0021.
 */
/*
CyclicBarrier可以用在系统的性能测试中，例如我们编写一个核心算法，但不能确定其可靠性和效率如何，
我们就可以让N个线程汇集到测试原点上，然后“一声令下”，所有的线程都引用该算法，即可观察出算法是否有缺陷。
 */
public class No131 {
    static class Worker implements Runnable {
        //关卡
        private CyclicBarrier cb;

        public Worker(CyclicBarrier _cb) {
            cb = _cb;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(new Random().nextInt(1000));
                System.out.println(Thread.currentThread().getName() + "到达汇合点");
                cb.await();
            } catch (Exception e) {
                //异常处理
            }
        }
    }

    public static void main(String[] args) {
        //设置汇集数量，以及汇集完成后的任务
        CyclicBarrier cb = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("隧道已经打通");
            }
        });
        //工人1挖隧道
        new Thread(new Worker(cb), "工人1").start();
        //工人2挖隧道
        new Thread(new Worker(cb), "工人2").start();

    }
}
