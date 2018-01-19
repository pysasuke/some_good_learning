package com.py.somesuggest.chapter3.no48;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 覆写equals方法必须覆写hashCode方法
 *
 * @author Administrator
 * @date 2017/10/17 0017
 */
/*
对象元素的hashCode方法返回值：
    它是一个对象的哈希码，是由Object类的本地方法生成的，确保每个对象有一个哈希码(这也是哈希算法的基本要求：
    任意输入k，通过一定算法f(k)，将其转换为非可逆的输出，对于两个输入k1和k2，若要求k1=k2，
    则必须f(k1)=f(k2)，但也允许k1!=k2,f(k1)=f(k2)的情况存在)。
 */
public class No48 {
    public static void main(String[] args) {
        //Person类的实例作为Map的key
        Map<Person, Object> map = new HashMap<Person, Object>() {
            {
                put(new Person("张三"), new Object());
            }
        };
        //Person类的实例作为List的元素
        List<Person> list = new ArrayList<Person>() {
            {
                add(new Person("张三"));
            }
        };
        //列表中是否包含
        boolean b1 = list.contains(new Person("张三"));
        boolean b2 = map.containsKey(new Person("张三"));
        //true
        System.out.println(b1);
        //false
        System.out.println(b2);
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
        if (null != obj && obj.getClass() == this.getClass()) {
            Person p = (Person) obj;
            if (p.getName() == null || name == null) {
                return false;
            } else {
                return name.equalsIgnoreCase(p.getName());
            }
        }
        return false;
    }

    //重写hashCode方法
    @Override
    public int hashCode(){
        return new HashCodeBuilder().append(name).toHashCode();
    }
}
