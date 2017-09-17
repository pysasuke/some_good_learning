package com.py.somesuggest.chapter1.no13;

import java.io.Serializable;

/**
 * 避免为final变量复杂赋值
 * Created by Administrator on 2017/9/10 0010.
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 91282334L;
    //通过方法返回值为final变量赋值
    //通过new生成的Person对象的final变量值都是initName()中的返回值
    public final String name = initName();

    //初始化方法名
    public String initName() {
//        return "混世魔王";
        return "德天使";
    }
    /*
    保存到磁盘上(或网络传输)的对象文件包括两部分：
        (1)类描述信息
        包括包路径、继承关系、访问权限、变量描述、变量访问权限、方法签名、返回值，以
        及变量的关联类信息。要注意的一点是，它并不是class文件的翻版，它不记录方法、构造
        函数、static变量等的具体实现，之所以类描述会被保存，很简单，是因为能去也能回嘛，这
        保证反序列化的健壮运行。
        (2)非瞬态(transient关键字)和非静态(static关键字)的实例变量值
        注意，这里的值如果是一个基本类型，好说，就是一个简单值保存下来；如果是复杂对象，
        也简单，连该对象和关联类信息一起保存，并且持续递归下去(关联类也必须实现Serializable
        接口，否则会出现序列化异常)，也就是说递归到最后，其实还是基本数据类型的保存。

        总计一下，反序列化时final变量在以下情况不会被重新赋值：
        通过构造函数为final变量赋值
        通过方法返回值为final变量赋值
        final修饰的属性不是基本类型(简单对象)
     */
    /*
     简单对象包括：8个基本类型，以及数组、字符串(字符串情况很复杂，不通过new关键字生成的String对象的
     情况下，final变量的赋值与基本数据类型相同)，但是不能方法赋值。
     */
}
