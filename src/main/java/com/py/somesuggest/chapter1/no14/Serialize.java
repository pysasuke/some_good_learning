package com.py.somesuggest.chapter1.no14;

import com.py.somesuggest.chapter1.no11.SerializationUtils;

/**
 * Created by Administrator on 2017/9/16 0016.
 */
public class Serialize {
    public static void main(String[] args) {
        //基本工资1000元，绩效工资2500元
        Salary salary = new Salary(1000,2500);
        //记录人员信息
        Person person = new Person("张三", salary);
        //HR系统持久化，并传递到计税系统
        SerializationUtils.writeObject(person);
    }
}
