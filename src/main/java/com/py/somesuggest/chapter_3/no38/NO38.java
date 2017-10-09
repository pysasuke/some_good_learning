package com.py.somesuggest.chapter_3.no38;

/**
 * 使用静态内部类提高封装性
 * Created by Administrator on 2017/10/9 0009.
 */
public class NO38 {
    public static void main(String[] args) {
        //定义张三这个人
        Person person =new Person("张三");
        //设置张三的家庭信息
        person.setHome(new Person.Home("上海","021"));
    }
}
