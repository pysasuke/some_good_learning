package com.py.somesuggest.frist_chapter.no12;

import java.io.Serializable;

/**
 * 避免用序列化类在构造函数中为不变量赋值
 * 注意：在序列化中，不使用构造函数为final变量赋值
 * Created by Administrator on 2017/9/10 0010.
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 71282334L;
    //不变量
//    public final String name = "混世魔王";    //如果final属性是一个直接量，在反序列化时会重新计算
    public final String name = "德天使";    //如果final属性是一个直接量，在反序列化时会重新计算
}
