package com.py.somesuggest.chapter1;

/**
 * 别让null值和空值威胁到变长方法
 * Created by Administrator on 2017/9/10 0010.
 */
public class NO5 {
    public void methodA(String str, Integer... is) {

    }

    public void methodA(String str, String... strs) {

    }

    public static void main(String[] args) {
        NO5 no5 = new NO5();
        no5.methodA("China", 0);
        no5.methodA("China", "People");
//        no5.methodA("China");    //NOT DO THIS    两个方法都符合调用要求
//        no5.methodA("China", null);    //NOT DO THIS  调用者隐藏了实参类型，这是非常危险的  两个方法都符合调用要求
        String[] strs = null;    //让编译器知道这个null值是String类型的
        no5.methodA("China", strs);
    }
}
