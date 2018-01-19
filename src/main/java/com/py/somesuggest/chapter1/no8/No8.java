package com.py.somesuggest.chapter1.no8;

/**
 * 不要让旧语法困扰你
 *
 * @author Administrator
 * @date 2017/9/10 0010
 */
public class No8 {
    public static void main(String[] args) {
        //数据定义及初始化
        int fee = 200;
        //其他业务处理
        //未报错
        saveDefault:save(fee);
        //其他业务处理
    }

    static void saveDefault() {

    }

    static void save(int fee) {

    }
}
