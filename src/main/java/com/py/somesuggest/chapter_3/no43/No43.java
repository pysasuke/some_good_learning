package com.py.somesuggest.chapter_3.no43;

/**
 * 避免对象的浅拷贝
 * Created by Administrator on 2017/10/14 0014.
 * 注意：浅拷贝只是Java提供的一种简单拷贝机制，不便于直接使用
 */
/*
clone方法提供的是一种浅拷贝方式，也就是说它并不会把对象的所有属性全部拷贝一份，而是选择性的拷贝，
它的拷贝规则如下：
1.基本变量
    如果变量是基本类型，则拷贝其值，比如int、float等
2.对象
    如果变量是一个实例对象，则拷贝地址引用，也就是说此时新拷贝出来的对象与原有对象
    共享改实例变量，不受访问权限的控制。
3.String字符串
    这个比较特殊，拷贝的也是一个地址，是个引用，但是在修改时，它会从字符串池
    中重新生成新的字符串，原有的字符串对象保持不变，在此处我们可以认为String
    是一个基本类型
 */
public class No43 {
    public static void main(String[] args) {
        //定义父亲
        Person father = new Person("父亲");
        //定义大儿子
        Person s1 = new Person("大儿子", father);
        //小儿子的信息是通过大儿子拷贝过来的
        Person s2 = s1.clone();
        s2.setName("小儿子");
        System.out.println(s1.getName()+" 的父亲是 "+s1.getFather().getName());    //大儿子 的父亲是 父亲
        System.out.println(s2.getName()+" 的父亲是 "+s2.getFather().getName());    //小儿子 的父亲是 父亲
        s1.getFather().setName("干爹");
        System.out.println(s1.getName()+" 的父亲是 "+s1.getFather().getName());    //大儿子 的父亲是 干爹
        System.out.println(s2.getName()+" 的父亲是 "+s2.getFather().getName());    //小儿子 的父亲是 干爹

    }
}

class Person implements Cloneable {
    //姓名
    private String name;
    //父亲
    private Person father;

    public Person(String _name) {
        name = _name;
    }

    public Person(String _name, Person _parent) {
        name = _name;
        father = _parent;
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

    //拷贝的实现
    @Override
    public Person clone() {
        Person p = null;
        try {
            //浅拷贝
//            p = (Person) super.clone();
            //深拷贝
            p = (Person) super.clone();
            p.setFather(new Person(p.getFather().getName()));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
