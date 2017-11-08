package com.py.somesuggest.chapter8.no111;

/**
 * 采用异常链传递异常
 * Created by Administrator on 2017/11/8 0008.
 */
public class No111 {

    public void stuff() throws IOException {
        try {

        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}
