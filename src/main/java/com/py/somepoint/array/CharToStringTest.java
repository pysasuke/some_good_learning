package com.py.somepoint.array;

import org.junit.Test;

/**
 * @author pysasuke
 * @create 2017-09-05 16:04
 */
public class CharToStringTest {
    @Test
    public void charToString(){
        char[] s = {'a', 'b', 'c'};
        String string1 = s.toString();
        String string2 = new String(s);
        String string3 = String.valueOf(s);
        //[C@69d0a921
        System.out.println(string1);
        //abc
        System.out.println(string2);
        //abc
        System.out.println(string3);
        System.out.println(string1.equals(string2));
        //true
        System.out.println(string2.equals(string3));
        System.out.println(string1.equals(string3));

    }
}
