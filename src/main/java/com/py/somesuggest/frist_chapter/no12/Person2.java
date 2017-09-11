package com.py.somesuggest.frist_chapter.no12;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/10 0010.
 */
public class Person2 implements Serializable {
    private static final long serialVersionUID = 91282334l;
    //不变量初始不赋值
    public final String name;

    //构造函数为不变量赋值
    /*
    反序列化时的另一个规则：
        反序列化时构造函数不会执行
     */
    public Person2() {
//        name = "混世魔王";
        name ="德天使";    //NOT DO THIS  反序列化时构造函数不会执行,若序列化后值被修改，值还是序列化时的值
    }
}
