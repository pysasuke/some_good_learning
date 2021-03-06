package com.py.somesuggest.chapter3.no49;


/**
 *
 * @author Administrator
 * @date 2017/10/17 0017
 */
/*
为什么通过println方法打印一个对象会调用toString方法？
    那是源于println的实现机制：如果是一个原始类型就直接打印，如果是一个类类型，则打印出其toString方法的返回值，如此而已！
 */
public class No49 {
    public static void main(String[] args) {
        //com.py.somesuggest.chapter3.no49.Person@5cad8086
        System.out.println(new Person("张三"));
    }
}
class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //覆写toString方法
    @Override
    public String toString(){
        return String.format("%s.name=%s",this.getClass(),name);
    }

}
