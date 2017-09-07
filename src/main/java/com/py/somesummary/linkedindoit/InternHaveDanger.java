package com.py.somesummary.linkedindoit;

/**
 * String的intern方法有用，但是也有危险
 * @author pysasuke
 * @create 2017-09-06 13:52
 */
//这个特性跟缓存很类似，但有一个限制，你不能设置最多可容纳的元素数目。
//因此，如果这些intern的字符串没有限制（比如字符串代表着一些唯一的id），那么它会让内存占用飞速增长
public class InternHaveDanger {
}
