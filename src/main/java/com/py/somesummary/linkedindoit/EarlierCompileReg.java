package com.py.somesummary.linkedindoit;

import java.util.regex.Pattern;

/**
 * 提前编译正则表达式
 *
 * @author pysasuke
 * @create 2017-09-06 13:39
 */
public class EarlierCompileReg {
    //字符串的操作在Java中算是开销比较大的操作。还好Java提供了一些工具让正则表达式尽可能地高效。
    // 动态的正则表达式在实践中比较少见。
    // 在接下来要举的例子中，每次调用String.replaceAll() 都包含了一个常量模式应用到输入值中去。
    // 因此我们预先编译这个模式可以节省CPU和内存的开销。
    private String replacement = "";
    private String regex = "";

    public static void main(String[] args) {
        String regex = "";
    }

    private String transform1(String term) {
        String outputTerm = term.replaceAll(regex, replacement);
        return outputTerm;
    }

    //预先编译
    private String transform2(String term) {
        Pattern pattern = Pattern.compile(regex);
        String outputTerm = pattern.matcher(term).replaceAll(replacement);
        return outputTerm;
    }
}
