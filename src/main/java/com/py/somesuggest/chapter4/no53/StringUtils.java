package com.py.somesuggest.chapter4.no53;

/**
 * Created by Administrator on 2017/10/22 0022.
 */
public class StringUtils {
    //删除字符串
    public static String remove(String source, String sub) {
//        return source.replaceAll(sub, "");
        return source.replace(sub, "");
    }
}
