package com.py.somesuggest.chapter2.no29;

/**
 * 优先选择基本类型
 * 注意：重申，基本类型优先考虑
 * Created by Administrator on 2017/9/18 0018.
 */
public class NO29 {
    public static void main(String[] args) {
        NO29 no29 = new NO29();
        int i = 140;
        //分别传递int类型和Integer类型
        no29.f(i);//基本类型的方法调用
        no29.f(Integer.valueOf(i));//基本类型的方法调用
    }
    public void f(long a){
        System.out.println("基本类型的方法调用");
    }
    public void f(Long a){
        System.out.println("包装类型的方法被调用");
    }
    /*
    1.f()方法重载没问题：一个形参是基本类型，一个形参是包装类型
    2.no29.f(i)不报错：编译器会自动把i的类型加宽，并将其转变为long型
    3.no29.f(Integer.valueOf(i))不报错：
        i通过valueOf方法包装成一个Integer对象
        由于没有f(Integer i)方法，编译器“聪明”地把Integer对象转成int
        int自动拓宽为long，编译结束
     */
}
