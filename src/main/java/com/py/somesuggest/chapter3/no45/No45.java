package com.py.somesuggest.chapter3.no45;

import java.util.ArrayList;
import java.util.List;

/**
 * 覆写equals方法时不要识别不出自己
 * Created by Administrator on 2017/10/16 0016.
 */
public class No45 {
    public static void main(String[] args) {
        Person p1 = new Person("张三");
        Person p2 = new Person("张三 ");
        List<Person> personList = new ArrayList<>();
        personList.add(p1);
        personList.add(p2);
        System.out.println(p1.equals(p2));    //true
        System.out.println(p2.equals(p2));    //false    相当于"张三 ".equals("张三")
        System.out.println("列表中是否包含张三："+personList.contains(p1));    //列表中是否包含张三：true
        System.out.println("列表中是否包含张三 ："+personList.contains(p2));    //列表中是否包含张三 ：false
    }
}

class Person {
    private String name;

    public Person(String _name) {
        name = _name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Person){
            Person p = (Person) obj;
//            return  name.equalsIgnoreCase(p.getName().trim());    //NOT DO THIS 它违背了equals方法的自反性原则：对于任何非空引用x,x.equals(x)应该返回true。
            return  name.equalsIgnoreCase(p.getName());    //NOT DO THIS 它违背了equals方法的自反性原则：对于任何非空引用x,x.equals(x)应该返回true。
        }
        return false;
    }
}