package com.py.somesummary.difficultcheck;

import java.sql.SQLException;

/**
 * 泛型与异常相关
 * @author pysasuke
 * @create 2017-09-05 16:37
 */
//Java的泛型并不是具体化的。这意味着在编译时，泛型的类型信息会“丢失”，并且泛型参数像是被它的限定类型替换了一样，
//或者当限定类型不存在时，泛型参数被替换成了Object。这就是大家所说的类型“擦除”
public class Mocker<T extends Exception> {
    private void pleaseThrow(final Exception t) throws T {
        throw (T) t;
    }

    public static void main(final String[] args) {
//        try{
        new Mocker<RuntimeException>().pleaseThrow(new SQLException());
    }
//        catch (final SQLException ex){    //CAN NOT DO THIS
//            ex.printStackTrace();
//        }
//    }
}
