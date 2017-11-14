package com.py.somesuggest.chapter9.no118;

/**
 * 不推荐覆写start方法
 * Created by Administrator on 2017/11/14 0014.
 * 注意：继承自Thread类的多线程类不必覆写start方法。
 */
/*
Thread类的start方法中关键的本地方法start0，它实现了启动线程、申请栈内存、运行run方法、修改线程状态等职责，
线程管理和栈内存管理都是由JVM负责的，如果覆盖了start方法，也就是撤销了线程管理和栈内存管理的能力。
 */
public class No118 {
}
