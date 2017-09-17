package com.py.somesuggest.chapter1.no14;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 使用序列化类的私有方法巧妙解决部分属性持久化问题
 * Created by Administrator on 2017/9/16 0016.
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 60407L;
    //姓名
    private String name;
    //薪水
    private Salary salary;

    public Person(String _name, Salary _salary) {
        name = _name;
        salary = _salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    //序列化委托方法
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(salary.getBasePay());
    }

    //反序列化时委托方法
    private void readObject(ObjectInputStream in)throws IOException,ClassNotFoundException{
        in.defaultReadObject();
        salary= new Salary(in.readInt(),0);
    }
}
