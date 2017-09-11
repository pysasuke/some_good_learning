package com.py.somesuggest.frist_chapter.no11;

import java.io.Serializable;

/**
 * 养成良好习惯，显式声明UID
 * 注意：显式声明serialVersionUID可以避免对象不一致，但尽量不要以这种方式向JVM"撒谎"
 * Created by Administrator on 2017/9/10 0010.
 */
public class Person implements Serializable {
    //流标识符
    /*
    JVM再反序列化时，会比较数据流中的serialVersionUID与类的serialVersionUID是否相同，
    如果相同，则认为此类没有发生改变，可以把数据流load为实例对象；如果不相同，对不起，我
    JVM不干了，抛出异常：java.io.InvalidClassException
    */
    private static final long serialVersionUID = 55799L;    //显式声明
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
