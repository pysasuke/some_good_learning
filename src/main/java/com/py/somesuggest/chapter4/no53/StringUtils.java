package com.py.somesuggest.chapter4.no53;

/**
 *
 * @author Administrator
 * @date 2017/10/22 0022
 */
public class StringUtils {
    /**
     * 删除字符串
     * @param source
     * @param sub
     * @return
     */
    public static String remove(String source, String sub) {
//        return source.replaceAll(sub, "");
        return source.replace(sub, "");
    }
}
