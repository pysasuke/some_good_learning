package com.py.somesuggest.frist_chapter.no12;

import com.py.somesuggest.frist_chapter.no11.SerializationUtils;

/**
 * Created by Administrator on 2017/9/10 0010.
 */
public class Deserialize {
    public static void main(String[] args) {
//        Person2 p = (Person2) SerializationUtils.readObject();
        Person p = (Person) SerializationUtils.readObject();
        System.out.println(p.name);
    }
}
