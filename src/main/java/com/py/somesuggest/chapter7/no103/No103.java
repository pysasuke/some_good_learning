package com.py.somesuggest.chapter7.no103;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射访问属性或方法时将Accessible设置为true
 * Created by Administrator on 2017/11/5 0005.
 * 注意：对于我们已经“习惯”了的代码。多思考一下为什么
 */
/*
Accessible的属性并不是我们语法层级理解的访问权限，而是值是否更容易获得，是否进行安全检查。
如果不需要则直接执行，这就可以大幅度地提升系统性能(当然了，由于取消了安全检查，也可以运行private方法、访问private私有属性了。)
经过测试，在大量的反射情况下，设置Accessible为true可以提升性能20倍以上。
 */

public class No103 {
    public final void doStuff() {
        System.out.println("Do Stuff");
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //反射获取方法
        Method m1 = No103.class.getMethod("doStuff");
        //打印是否可访问
        System.out.println("Accessible=" + m1.isAccessible());    //Accessible=false
        m1.setAccessible(true);
        //执行方法
        m1.invoke(new No103());    //Do Stuff
    }
}
