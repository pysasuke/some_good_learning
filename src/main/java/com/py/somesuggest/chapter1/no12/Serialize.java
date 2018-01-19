package com.py.somesuggest.chapter1.no12;

import com.py.somesuggest.chapter1.no11.SerializationUtils;

/**
 *
 * @author Administrator
 * @date 2017/9/10 0010
 */
public class Serialize {
    public static void main(String[] args){
        //序列化以持久保存
//        SerializationUtils.writeObject(new Person2());
        SerializationUtils.writeObject(new Person());
    }
}
