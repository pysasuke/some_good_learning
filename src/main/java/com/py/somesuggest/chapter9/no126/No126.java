package com.py.somesuggest.chapter9.no126;

import java.util.concurrent.*;

/**
 * 适时选择不同的线程池来实现
 *
 * @author Administrator
 * @date 2017/11/19 0019
 */
/*
corePoolSize：最小线程数
    线程池启动后，在池中保持线程的最小数量。需要说明的是线程数量是逐步到达corePoolSize值的，例如corePoolSize被设置为10，而任务数量只要5，则线程池中最多会启动5个线程，而不是一次性启动10个线程。
maximumPoolSize：最大线程数量
    这是池中能够容纳的最大线程数量，如果超出，则使用RejectedExecutionHandler拒绝策略处理
keepAliveTime：线程最大生命期
    这里的生命期有两个约束条件：一是该参数针对的是超过corePoolSize数量的线程；二是处于非运行状态的线程。这么说吧，如果corePoolSize为10，maximumPoolSize为20，此时线程池中有15个线程在运行，一段时间后，其中有3个线程处于等待状态的时间超过了keepAliveTime指定的时间，则结束这3个线程，此时线程池中则还有12个线程正在运行。
unit：时间单位
    这是keepAliveTime的时间单位，可以是纳秒、毫秒、秒、分钟等选项
workQueue：任务队列
    当线程池中的线程都处于运行状态，而此时任务数量继续增加，则需要有一个容器来容纳这些任务，这就是任务队列。
threadFactory：线程工厂
    定义如何启动一个线程，可以设置线程名称，并且可以确认是否是后台线程等。
handler：拒绝任务处理器
    由于超出线程数量和队列容量而对继续增加的任务进行处理的程序。

//最完整的构造函数
public ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              ThreadFactory threadFactory,
                              RejectedExecutionHandler handler) {
        //检验输入条件
        if (corePoolSize < 0 ||
            maximumPoolSize <= 0 ||
            maximumPoolSize < corePoolSize ||
            keepAliveTime < 0)
            throw new IllegalArgumentException();
        //检验运行环境
        if (workQueue == null || threadFactory == null || handler == null)
            throw new NullPointerException();
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.workQueue = workQueue;
        this.keepAliveTime = unit.toNanos(keepAliveTime);
        this.threadFactory = threadFactory;
        this.handler = handler;
    }
    线程池的管理是这样一个过程：首先创建线程池，然后根据任务的数量逐步将线程增大到corePoolSize数量，
如果此时仍有任务增加，则放置到workQueue中，直到workQueue爆满为止，然后继续增加池中的线程数量(增强处理能力)，
最终达到maximumPoolSize，那如果此时还有任务要增加进来呢？这就需要handler来处理了，或者丢弃新任务，或者拒绝新任务，或者挤占已有任务等。
    在任务队列和线程池都饱和的情况下，一旦有线程处于等待(任务处理完毕，没有新任务增加)状态的时间超过keepAliveTime，则该线程终止，
也就是说池中线程数量会逐渐降低，直至corePoolSize数量为止。

newSingleThreadExecutor：单线程池
    顾名思义就是一个池中只有一个线程在运行，该线程永不超时。而且由于是一个线程，当有多个任务需要处理时，会将他们放置到一个无界阻塞队列中逐个处理。
newCachedThreadPool:缓冲功能的线程池
    建立了一个线程池，而且线程数量是没有限制的(当然，不能超过Integer的最大值)，新增一个任务即有一个线程处理，或者复用之前空闲的线程，或者新启动一个线程，
但是一旦一个线程在60秒内一直是处于等待状态时(也就是一分钟没工作可做)，则会被终止。
    这里需要说明的是，任务队列使用了同步阻塞队列，这意味着向队列中加入一个元素，即可唤醒一个线程(新创建的线程或复用池中空闲线程)来处理，这种队列已经没有队列深度的概念了。
newFixedThreadPool：固定线程数量的线程池
    在初始化时已经决定了线程的最大数量，若任务添加的能力超出了线程处理能力，则建立阻塞队列容纳多余的任务
    它的corePoolSize和maximumPoolSize是相等的，如果任务增长速度非常快，超过了LinkedBlockingQueue的最大容量(Integer的最大值)，那此时会如何处理呢？会按照ThreadPoolExecutor默认的拒绝策略(默认是DiscardPolicy，直接丢弃)来处理。
 */
public class No126 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建单线程执行器
        ExecutorService es = Executors.newSingleThreadExecutor();
        //执行一个任务
        Future<String> future = es.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "success";
            }
        });
        //获得任务执行后的返回值
        //返回值：success
        System.out.println("返回值：" + future.get());
        //关闭执行器
        es.shutdown();
    }
}
