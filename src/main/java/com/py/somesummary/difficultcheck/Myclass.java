package com.py.somesummary.difficultcheck;

/**
 * 对象相关
 * @author pysasuke
 * @create 2017-09-05 16:59
 */
public class Myclass {
    private String name;

    public static void main(String[] args) {
        Myclass m1 = new Myclass();
        Myclass m2 = new Myclass();
        m1.name = m2.name = "m1";
//        m1=m2;
//        m2.name="new name";
        callMe(m1, m2);
//        callMe2(m1,m2);
        System.out.println(m1 + " & " + m2);//com.py.somesummary.difficultcheck.Myclass@4554617c & com.py.somesummary.difficultcheck.Myclass@74a14482
        System.out.println(m1.name + " & " + m2.name);//m1 & new name
    }

    private static void callMe(Myclass... m) {
        m[0] = m[1];//此时m[0]和m[1]都指向m[1](即m2)
        m[1].name = "new name";////此时m[1]指向的对象(即m2)的name被改成"new name",但m[0]原本指向的对象(m1)却未曾修改过
    }

    private static void callMe2(Myclass m1, Myclass m2) {
        m1=m2;
        m2.name = "new name";
    }
}
