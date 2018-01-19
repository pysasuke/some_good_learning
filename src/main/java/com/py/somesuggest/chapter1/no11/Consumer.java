package com.py.somesuggest.chapter1.no11;

/**
 *
 * @author Administrator
 * @date 2017/9/10 0010
 */
public class Consumer {
    public static void main(String[] args) {
        //反序列化
        Person p = (Person) SerializationUtils.readObject();
        System.out.println("name=" + p.getName());
    }
}
