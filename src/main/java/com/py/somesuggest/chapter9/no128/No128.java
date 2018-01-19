package com.py.somesuggest.chapter9.no128;

import java.util.concurrent.TimeUnit;

/**
 * 预防线程死锁
 *
 * @author Administrator
 * @date 2017/11/20 0020
 */
/*
线程死锁需要四个条件：
    互斥条件：一个资源每次只能被一个线程使用
    资源独占条件：一个线程因请求资源而阻塞时，对已获得的资源保持不放
    不剥夺条件：线程已获得的资源在未使用完之前，不能强行剥夺
    循环等待条件：若干线程之间形成一种头尾相接的循环等待资源关系
解决线程死锁问题：
    避免或减少资源共享
    使用自旋锁
        如果在获取自旋锁时，没有任何执行单元保持该锁，那么将立即得到锁；
        如果在获取自旋锁时锁已经有保持者，那么获取锁操作将“自旋”在那里，知道该自旋锁的保持者释放了锁为止。
        //立即获得锁，或者2秒等待锁资源(2秒后还未获得锁资源，则结束运行)
        if(lock.tryLock(2,TimeUnit.SECONDS))

对付死锁的最好办法是测试：
    提高测试覆盖率，建立有效的边界测试，加强资源监控这些方法能使死锁无所遁形，即使发生了死锁现象也能迅速查找到原因，提高系统的可靠性。
 */
public class No128 {

}
