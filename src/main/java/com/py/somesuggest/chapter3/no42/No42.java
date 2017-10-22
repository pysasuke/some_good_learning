package com.py.somesuggest.chapter3.no42;

/**
 * 让工具类不可实例化
 * Created by Administrator on 2017/10/14 0014.
 */
//构造函数不仅仅设置成private访问权限，还要抛异常(java的反射，修改个构造函数的访问权限易如反掌)
public class No42 {
    private No42(){
        throw new Error("不要实例化我！");
    }
}
