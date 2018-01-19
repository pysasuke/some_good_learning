package com.py.somesuggest.chapter6.no86;

/**
 * 在switch的default代码块中增加AssertionError错误
 *
 * @author Administrator
 * @date 2017/10/31 0031
 */
public class No86 {
    public void doSomething(LogLevel logLevel) {
        switch (logLevel) {
            case DEBUG:
                System.out.println("DEBUG");
                break;
            case INFO:
                System.out.println("INFO");
                break;
            case WARN:
                System.out.println("WARN");
                break;
            case ERROR:
                System.out.println("ERROR");
                break;
            //这样可以保证在增加一个枚举的情况下，若其他代码未修改，运行期马上就会报错，这样一来就很容易查找到错误。
            default:
                throw new AssertionError("为找到匹配值");
        }
    }
}

enum LogLevel {
    DEBUG, INFO, WARN, ERROR
}