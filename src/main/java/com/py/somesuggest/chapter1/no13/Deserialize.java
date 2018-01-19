package com.py.somesuggest.chapter1.no13;

import com.py.somesuggest.chapter1.no11.SerializationUtils;

/**
 *
 * @author Administrator
 * @date 2017/9/10 0010
 */
public class Deserialize {
    public static void main(String[] args) {
        Person p = (Person) SerializationUtils.readObject();
        System.out.println(p.name);
    }
}
