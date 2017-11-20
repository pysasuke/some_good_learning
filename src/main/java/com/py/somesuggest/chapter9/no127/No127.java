package com.py.somesuggest.chapter9.no127;

import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock与synchronized是不一样的
 * Created by Administrator on 2017/11/19 0019.
 * 注意：两种不同的锁机制，根据不同的情况来选择
 */
//灵活、强大则选择Lock，快捷、安全则选择synchronized
/*
1.显式锁是对象级别的锁，而内部锁是类级别的锁，把Lock定义为多线程类的私有属性是起不到资源互斥作用的，除非是把Lock定义为所以线程的共享变量。
2.Lock支持更细粒度的锁控制
    读写锁允许同时又多个对操作但只允许有一个写操作，也就是当有一个写线程在执行时，所有的读线程和写线程都会阻塞，直到写线程释放锁资源为止，而读锁则可以有多个线程同时执行。
3.Lock是无阻塞锁，synchronized是阻塞锁
4.Lock可实现公平锁，synchronized只能实现非公平锁
    当一个线程A持有锁，而线程B、C处于阻塞(或等待)状态时，若线程A释放锁，JVM将从线程B、C中随机选择一个线程持有锁并使其获得执行权，这叫做非公平锁(因为它抛弃了先来后到的顺序)；
    若JVM选择了等待时间最长的一个线程持有锁，则为公平锁(保证每个线程的等待时间均衡)。
5.Lock是代码级的，synchronized是JVM级的
    Lock是通过编码实现的，synchronized是在运行期由JVM解释的
 */
public class No127 {
    public static void runTasks(Class<? extends Runnable> clz) throws Exception {
        ExecutorService es = Executors.newCachedThreadPool();
        System.out.println("开始执行" + clz.getSimpleName() + "任务");
        //启动三个线程
        for (int i = 0; i < 3; i++) {
            es.submit(clz.newInstance());
        }
        //等待足够长的时间，然后关闭执行器
        TimeUnit.SECONDS.sleep(10);
        System.out.println(clz.getSimpleName() + "执行完毕");
        es.shutdown();
    }

    public static void main(String[] args) throws Exception {
        //运行显式锁任务
        runTasks(TaskWithLock.class);
        //运行内部锁任务
        runTasks(TaskWithSync.class);
    }
}

class Task {
    public void doSomething() {
        try {
            //每个线程等待2秒钟，注意将此时的线程转为WAITING状态
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            //异常处理
            e.printStackTrace();
        }
        StringBuffer sb = new StringBuffer();
        //线程名称
        sb.append("线程名称：" + Thread.currentThread().getName());
        //运行的时间戳
        sb.append("执行时间：" + Calendar.getInstance().get(13) + "s");
        System.out.println(sb);
    }
}

//显式锁任务
class TaskWithLock extends Task implements Runnable {
    //声明显式锁
    private final Lock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            //开始锁定
            lock.lock();
            doSomething();
        } finally {
            lock.unlock();
        }
    }
}

//内部锁任务
class TaskWithSync extends Task implements Runnable {

    @Override
    public void run() {
        //内部锁
        synchronized ("A") {
            doSomething();
        }
    }
}
/*
开始执行TaskWithLock任务
线程名称：pool-1-thread-3执行时间：39s
线程名称：pool-1-thread-2执行时间：39s
线程名称：pool-1-thread-1执行时间：39s
TaskWithLock执行完毕
开始执行TaskWithSync任务
线程名称：pool-2-thread-1执行时间：49s
线程名称：pool-2-thread-2执行时间：51s
线程名称：pool-2-thread-3执行时间：53s
TaskWithSync执行完毕
 */