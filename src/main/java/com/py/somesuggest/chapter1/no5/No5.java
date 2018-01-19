package com.py.somesuggest.chapter1.no5;

/**
 * 别让null值和空值威胁到变长方法
 *
 * @author Administrator
 * @date 2017/9/10 0010
 */
public class No5 {
    public void methodA(String str, Integer... is) {

    }

    public void methodA(String str, String... strs) {

    }

    public static void main(String[] args) {
        No5 no5 = new No5();
        no5.methodA("China", 0);
        no5.methodA("China", "People");
        //NOT DO THIS    两个方法都符合调用要求
//        no5.methodA("China");
        //NOT DO THIS  调用者隐藏了实参类型，这是非常危险的  两个方法都符合调用要求
//        no5.methodA("China", null);
        //让编译器知道这个null值是String类型的
        String[] strs = null;
        no5.methodA("China", strs);
    }
}
