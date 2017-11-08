package com.py.somesuggest.chapter8.no111;

/**
 * Created by Administrator on 2017/11/8 0008.
 */
public class IOException extends Exception {
    //定义异常原因
    public IOException(String message) {
        super(message);
    }

    //定义异常原因，并携带原始异常
    public IOException(String message, Throwable cause) {
        super(message, cause);
    }

    //保留原始异常信息
    public IOException(Throwable cause) {
        super(cause);
    }
}
