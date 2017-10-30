package com.py.somesuggest.chapter5.no80;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

/**
 * 多线程使用Vector或HashTable
 * Created by Administrator on 2017/10/30 0030.
 * 注意：多线程环境下考虑使用Vector或HashTable
 */
/*
并发修改(比如一个线程增加，一个线程删除)，这不属于多线程的范畴
 */
public class No80 {
    public static void main(String[] args) {
        //火车票列表
//        final List<String> tickets = new ArrayList<>();
        final Vector<String> tickets = new Vector<>();
        //初始化票据池
        for (int i = 0; i < 10000; i++) {
            tickets.add("火车票" + i);
        }
        //退票
        Thread returnThread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    tickets.add("车票" + new Random().nextInt());
                }
            }
        };
        //售票
        Thread salsThread = new Thread() {
            @Override
            public void run() {
                for (String ticket : tickets) {
                    tickets.remove(ticket);
                }
            }
        };
        //启动退票线程
//        returnThread.start();
        //启动售票线程
//        salsThread.start();
        //10个窗口售票
        for (int i = 0; i < 10; i++) {
            new Thread() {
                public void run() {
                    while (true) {
                        System.out.println(Thread.currentThread().getId() + "--" + tickets.remove(0));
                    }
                }
            }.start();
        }
    }
}
/*
Exception in thread "Thread-1" java.util.ConcurrentModificationException
	at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:901)
	at java.util.ArrayList$Itr.next(ArrayList.java:851)
	at com.py.somesuggest.chapter5.no80.No80$2.run(No80.java:32)
 */