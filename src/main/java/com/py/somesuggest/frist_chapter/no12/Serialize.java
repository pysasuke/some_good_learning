package com.py.somesuggest.frist_chapter.no12;

import com.py.somesuggest.frist_chapter.no11.SerializationUtils;

/**
 * Created by Administrator on 2017/9/10 0010.
 */
public class Serialize {
    public static void main(String[] args){
        //序列化以持久保存
//        SerializationUtils.writeObject(new Person2());
        SerializationUtils.writeObject(new Person());
    }
}
