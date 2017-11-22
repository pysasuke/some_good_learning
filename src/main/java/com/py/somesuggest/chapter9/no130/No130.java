package com.py.somesuggest.chapter9.no130;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 使用CountDownLatch协调子线程
 * Created by Administrator on 2017/11/21 0021.
 */
/*
CountDownLatch对于多个子任务的计算特别有效，比如一个异步任务需要拆分成10个子任务执行，主任务必须要知道子任务是否完成，
所有子任务完成后才能进行合并计算，从而保证了一个主任务的逻辑正确性。
 */
public class No130 {
    static class Runner implements Callable<Integer> {
        //开始信号
        private CountDownLatch begin;
        //结束信号
        private CountDownLatch end;

        public Runner(CountDownLatch _begin, CountDownLatch _end) {
            begin = _begin;
            end = _end;
        }

        @Override
        public Integer call() throws Exception {
            //跑步的成绩
            int score = new Random().nextInt(25);
            //等待发令枪想起
            begin.await();
            //跑步中
            TimeUnit.MILLISECONDS.sleep(score);
            end.countDown();
            return score;
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //参加赛跑人数
        int num = 10;
        //发令枪只响一次
        CountDownLatch begin = new CountDownLatch(1);
        //参与跑步有多个跑道
        CountDownLatch end = new CountDownLatch(num);
        //每个跑步者一个跑道
        ExecutorService es = Executors.newFixedThreadPool(num);
        //记录比赛成绩
        List<Future<Integer>> futures = new ArrayList<>();
        //跑步者就位，所有线程处于等待状态
        for (int i = 0; i < num; i++) {
            futures.add(es.submit(new Runner(begin, end)));
        }
        //发令枪响，跑步者开始跑步
        begin.countDown();
        //等待所有跑步者跑完全程
        end.await();
        int count =0;
        //总分统计
        for(Future<Integer> f :futures){
            count += f.get();
        }
        System.out.println("平均分数为:"+count/num);
    }
}
