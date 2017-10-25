package com.py.somesuggest.chapter5.no73;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 使用Comparator进行排序
 * Created by Administrator on 2017/10/25 0025.
 * 注意：Comparable接口可以作为实现类的默认排序方法，Comparator接口则是一个类的扩展排序工具。
 */
/*
实现了Comparable接口的类表明自身是可比较的，有了比较才能进行排序；
而Comparator接口是一个工具类接口，用作比较，它与原有类的逻辑没有关系，只是实现两个类的比较逻辑，
从这方面来说，一个类可以有很多的比较器，只要有业务需求就可以产生比较器，有比较器就可以产生N种多种排序，
而CompareTo方法基本不会改变，也就是说一个类只能有一个固定的、由compareTo方法提供的默认排序算法。
 */
public class No73 {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>(5);
        //一个老板
        list.add(new Employee(1001, "张三", Position.Boss));
        //两个经理
        list.add(new Employee(1006, "赵七", Position.Manager));
        list.add(new Employee(1003, "王五", Position.Manager));
        //两个职员
        list.add(new Employee(1002, "李四", Position.Staff));
        list.add(new Employee(1005, "马六", Position.Staff));
        //按照id排序，也就是按照资历深浅排序
//        Collections.sort(list);
        Collections.sort(list, new PositionComparator());
        for (Employee employee : list) {
            System.out.println(employee);
        }
        /*
        com.py.somesuggest.chapter5.no73.Employee@2c7b84de[id=1001,name=张三,position=Boss]
        com.py.somesuggest.chapter5.no73.Employee@24d46ca6[id=1002,name=李四,position=Staff]
        com.py.somesuggest.chapter5.no73.Employee@372f7a8d[id=1003,name=王五,position=Manager]
        com.py.somesuggest.chapter5.no73.Employee@28a418fc[id=1005,name=马六,position=Staff]
        com.py.somesuggest.chapter5.no73.Employee@5305068a[id=1006,name=赵七,position=Manager]
         */
    }
}

class Employee implements Comparable<Employee> {
    //id是根据进入公司的先后顺序编码的
    private int id;
    //姓名
    private String name;
    //职位
    private Position position;

    public Employee(int _id, String _name, Position _position) {
        id = _id;
        name = _name;
        position = _position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    //按照id号排序，也就是资历的深浅排序
//    @Override
//    public int compareTo(Employee o) {
//        return new CompareToBuilder().append(id, o.id).toComparison();
//    }
    @Override
    public int compareTo(Employee o) {
        return new CompareToBuilder()
                .append(position, o.position)    //职位排序
                .append(id, o.id).toComparison();    //工号排序
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}

enum Position {
    Boss, Manager, Staff
}

class PositionComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        //按职位降序排列
        return o1.getPosition().compareTo(o2.getPosition());
    }
}