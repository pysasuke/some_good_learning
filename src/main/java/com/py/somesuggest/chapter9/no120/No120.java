package com.py.somesuggest.chapter9.no120;

/**
 * 不使用stop方法停止线程
 * Created by Administrator on 2017/11/14 0014.
 */
public class No120 {
}

class SafeStopThread extends Thread {
    //此变量必须加上volatile
    private volatile boolean stop = false;

    @Override
    public void run() {
        //判断线程体是否运行
        while (!stop) {    //自己理解，原本是stop
            //Do Something
        }
        //判断线程体是否运行
        while (!isInterrupted()) {
            //Do Something
        }
        //线程终止
    }

    public void terminate() {
        stop = true;
    }
}

