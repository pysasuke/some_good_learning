package com.py.somesummary.becareful;

/**
 * Created by pysasuke on 2017/7/25.
 * 循环内不要不断创建对象引用
 */
public class NotCreateObjectInLoop {
    public static void main(String[] args) {
        int count = 10;
//        for (int i = 1; i <= count; i++) {
//            Object obj = new Object();  //NOT DO THIS  这种做法会导致内存中有count份Object对象引用存在，count很大的话，就耗费内存了
//        }
        Object obj = null;
        for (int i = 0; i <= count; i++) {
            obj = new Object();
        }
    }
}
