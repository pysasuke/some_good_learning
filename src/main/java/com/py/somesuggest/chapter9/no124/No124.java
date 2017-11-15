package com.py.somesuggest.chapter9.no124;

import java.util.concurrent.*;

/**
 * 异步运算考虑使用Callable接口
 * Created by Administrator on 2017/11/15 0015.
 */
public class No124 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //生成一个单线程的异步执行器
        ExecutorService es = Executors.newSingleThreadExecutor();
        //线程执行后的期望值
        Future<Integer> future = es.submit(new TaxCalculator(100));
        while (!future.isDone()) {
            //还没有运算完成，等待200毫秒
            TimeUnit.MILLISECONDS.sleep(200);
            //输出进度符号
            System.out.print("#");
        }
        System.out.println("\n计算完成，税金是：" + future.get() + "元");
        es.shutdown();
    }
}

//税率计算器
class TaxCalculator implements Callable<Integer> {
    //本金
    private int seedMoney;

    //接收主线程提供的参数
    public TaxCalculator(int _seedMoney) {
        seedMoney = _seedMoney;
    }

    @Override
    public Integer call() throws Exception {
        //复杂计算，运行一次需要10秒
        TimeUnit.MILLISECONDS.sleep(10000);
        return seedMoney / 10;
    }
}
/*
##################################################
计算完成，税金是：10元
 */