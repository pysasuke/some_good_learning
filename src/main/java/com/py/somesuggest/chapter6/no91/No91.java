package com.py.somesuggest.chapter6.no91;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 枚举和注解结合使用威力更大
 * Created by Administrator on 2017/11/3 0003.
 */
public class No91 {
    public static void main(String[] args) {
        //初始化商业逻辑
        Foo b = new Foo();
        //获取注解
        Access access = b.getClass().getAnnotation(Access.class);
        if (null == access || !access.level().identify()) {
            //没有Access注解或者鉴权失败
            System.out.println(access.level().REFUSE_WORD);
        }
    }
}
//鉴权人接口
interface Identifier {
    //无访问权限时的礼貌语
    String REFUSE_WORD = "您无权访问";

    //鉴权
    public boolean identify();
}
//枚举实现
enum CommonIdentifier implements Identifier {
    //权限级别
    Reader, Author, Admin;

    //实现权限
    @Override
    public boolean identify() {
        return false;
    }
}

//该注解是标注在类上面的，并且保留到运行期
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Access {
    //什么级别可以访问。默认是管理员
    CommonIdentifier level() default CommonIdentifier.Admin;
}

//资源类
@Access(level = CommonIdentifier.Author)
class Foo {

}