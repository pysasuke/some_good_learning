package com.py.somesuggest.frist_chapter;

/**
 * 不要让旧语法困扰你
 * Created by Administrator on 2017/9/10 0010.
 */
public class NO8 {
    public static void main(String[] args) {
        //数据定义及初始化
        int fee = 200;
        //其他业务处理
        saveDefault:save(fee);    //未报错
        //其他业务处理
    }

    static void saveDefault() {

    }

    static void save(int fee) {

    }
}
