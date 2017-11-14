package com.py.somesuggest.chapter8.no115;

/**
 * 使用Throwable获得栈信息
 * Created by Administrator on 2017/11/13 0013.
 */
public class No115 {
}

class Foo {
    public static boolean m() {
        //取得当前栈信息
        StackTraceElement[] sts = new Throwable().getStackTrace();
        //检查是否是m1方法调用
        for (StackTraceElement st : sts) {
            if (st.getMethodName().equals("m1")) {
                return true;
            }
        }
//        return false;
        //该方法常用作离线注册码校验，当破解者试图暴力破解时，由于主执行者不是期望的值，因此会返回一个经过包装和混淆的异常信息，大大增加了破解的难度。
        throw new RuntimeException("除m1方法外，该方法不允许其他方法调用");
    }
}

//调用者
class Invoker {
    //该方法打印出true
    public static void m1() {
        System.out.println(Foo.m());
    }

    //该方法打印出false
    public static void m2() {
        System.out.println(Foo.m());
    }
}