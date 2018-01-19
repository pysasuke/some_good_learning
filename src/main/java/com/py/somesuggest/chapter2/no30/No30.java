package com.py.somesuggest.chapter2.no30;

import java.util.Random;

/**
 * 不要随便设置随机种子
 * 注意：若非必要，不要设置随机种子数
 *
 * @author Administrator
 * @date 2017/9/18 0018
 */
/*
随机数的产生取决于种子：
种子不同，产生不同的随机数
种子相同，即使实例不同也产生相同的随机数
 */
public class No30 {
    public static void main(String[] args) {
        //Random类的默认种子(无参构造)是System.nanoTime()的返回值(距离某一个固定时间点的纳秒数)
        Random r = new Random();
        for (int i = 1; i < 4; i++) {
            System.out.println("第" + i + "次:" + r.nextInt());
        }
    }
}
