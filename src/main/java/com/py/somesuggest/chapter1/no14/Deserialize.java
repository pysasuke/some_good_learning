package com.py.somesuggest.chapter1.no14;

import com.py.somesuggest.chapter1.no11.SerializationUtils;

/**
 * Created by Administrator on 2017/9/16 0016.
 */
public class Deserialize {
    public static void main(String[] args) {
        //技术系统反序列化，并打印信息
        Person person = (Person) SerializationUtils.readObject();
        StringBuffer sb = new StringBuffer();
        sb.append("姓名：" + person.getName());
        sb.append("\t 基本工资：" + person.getSalary().getBasePay());
        sb.append("\t 绩效工资：" + person.getSalary().getBonus());
        System.out.println(sb);
    }
}
