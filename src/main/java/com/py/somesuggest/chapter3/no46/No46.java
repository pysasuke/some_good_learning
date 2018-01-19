package com.py.somesuggest.chapter3.no46;

import java.util.ArrayList;
import java.util.List;

/**
 * equals应该考虑null值情景
 *
 * @author Administrator
 * @date 2017/10/16 0016
 */
public class No46 {
    public static void main(String[] args) {
        Person p1 = new Person("张三");
        Person p2 = new Person(null);
        List<Person> personList = new ArrayList<>();
        personList.add(p1);
        personList.add(p2);
        //列表中是否包含张三：true
        System.out.println("列表中是否包含张三：" + personList.contains(p1));
        //Exception in thread "main" java.lang.NullPointerException
        System.out.println("列表中是否包含张三 ：" + personList.contains(p2));
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

    @Override
    public boolean equals(Object obj) {
//        if(obj instanceof Person){
//            Person p = (Person) obj;
//            return  name.equalsIgnoreCase(p.getName());    //NOT DO THIS 它违背了equals方法的对称性原则：对于任何引用x和y的情形，如果x.equals(y)返回true，那么y.equals(x)也应该返回true。
//        }
        if (obj instanceof Person) {
            Person p = (Person) obj;
            if (p.getName() == null || name == null) {
                return false;
            } else {
                return name.equalsIgnoreCase(p.getName());
            }
        }
        return false;
    }
}