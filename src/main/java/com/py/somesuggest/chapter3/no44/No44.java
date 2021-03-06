package com.py.somesuggest.chapter3.no44;

import java.io.Serializable;
import java.lang.annotation.Native;

/**
 * 推荐使用序列化实现对象的拷贝
 *
 * @author Administrator
 * @date 2017/10/16 0016
 */
//采用序列化拷贝时还有一个更简单的办法，即使用Apache下的commons工具包中的Serialization Utils类，直接使用更加简洁方便。
public class No44 {
    public static void main(String[] args) {
        //定义父亲
        Person father = new Person("父亲");
        //定义大儿子
        Person s1 = new Person("大儿子", father);
        //小儿子的信息是通过大儿子拷贝过来的
        Person s2 = CloneUtils.clone(s1);
        s2.setName("小儿子");
        //大儿子 的父亲是 父亲
        System.out.println(s1.getName() + " 的父亲是 " + s1.getFather().getName());
        //小儿子 的父亲是 父亲
        System.out.println(s2.getName() + " 的父亲是 " + s2.getFather().getName());
        s1.getFather().setName("干爹");
        //大儿子 的父亲是 干爹
        System.out.println(s1.getName() + " 的父亲是 " + s1.getFather().getName());
        //小儿子 的父亲是 父亲
        System.out.println(s2.getName() + " 的父亲是 " + s2.getFather().getName());

    }
}

class Person implements Serializable {
    @Native private static final long serivalVersionUID = 1611293231L;
    /**
     * 姓名
     */
    private String name;
    /**
     * 父亲
     */
    private Person father;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Person parent) {
        this.name = name;
        this.father = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }


}
