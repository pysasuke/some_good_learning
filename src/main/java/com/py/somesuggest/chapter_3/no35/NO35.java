package com.py.somesuggest.chapter_3.no35;

/**
 * 避免在构造函数中初始化其他类
 * Created by Administrator on 2017/10/9 0009.
 */
public class NO35 {
    public static void main(String[] args) {
        Son s = new Son();
        s.doSomething();
    }
}
//父类
class Father {
    Father() {
        new Other();    //NOT DO THIS
    }
}
//子类
class Son extends Father {
    public void doSomething() {
        System.out.println("Hi,show me something");
    }
}
//相关类
class Other {
    public Other() {
        new Son();    //NOT DO THIS
    }
}
/*
java.lang.StackOverflowError异常：
    声明s变量时，调用了Son的无参构造函数,JVM又默认调用了分类Father的无参构造函数，
    接着Father类又初始化了Other类,而Other类又调用了Son类，
    于是一个死循环就诞生了，直到栈内存被消耗完毕为止。



 */

