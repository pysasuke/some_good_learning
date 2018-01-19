package com.py.somesuggest.chapter9.no119;

/**
 * 启动线程stop方法是不可靠的(1.8好像可行)
 *
 * @author Administrator
 * @date 2017/11/14 0014
 */
public class No119 {
    public static void main(String[] args) {
        //不分昼夜地制造垃圾邮件
        while (true) {
            //多线程多个垃圾邮件制造机
            SpamMachine sm = new SpamMachine();
            /*
            //条件判断，不符合条件就设置该线程不可执行
            if(!false){
                sm.stop();
            }
            //如果线程是stop状态，则不会启动
            sm.start();
            */

            //直接通过判断条件啦觉得线程是否可启用
            if(!false){
                new SpamMachine().start();
            }
        }
    }
}

class SpamMachine extends Thread {
    @Override
    public void run() {
        //制造垃圾邮件
        System.out.println("制造垃圾邮件");
    }
}