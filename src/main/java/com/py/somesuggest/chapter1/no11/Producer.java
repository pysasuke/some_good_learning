package com.py.somesuggest.chapter1.no11;

/**
 *
 * @author Administrator
 * @date 2017/9/10 0010
 */
public class Producer {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("混世魔王");
        //序列化，保存到磁盘上
        SerializationUtils.writeObject(person);
    }
}
