package com.py.somesuggest.chapter8.no116;

/**
 * 异常只为异常服务
 * Created by Administrator on 2017/11/13 0013.
 * 注意：异常只为确实异常的事件服务。
 */
public class No116 {

    /*
    (1)异常判断降低了系统性能
    (2)降低了代码的可读性，只有详细了解valueOf方法的人才能读懂这样的代码，因为valueOf抛出的是一个非受检异常
    (3)隐藏了运行期可能产生的错误，catch到异常，但没有做任何处理
     */
    public static <T extends Enum<T>> boolean Contain(Class<T> c, String name) {
        boolean result = false;
        try {
            Enum.valueOf(c, name);
            result = true;
        } catch (RuntimeException e) {
            //只要是抛出异常，则认为是不包含
        }
        return result;
    }

    //判断一个枚举是否包含String枚举项
    public static <T extends Enum<T>> boolean Contain_modify(Class<T> c, String name) {
        //遍历枚举项
        for (T t : c.getEnumConstants()) {
            //枚举项名称是否相等
            if (t.name().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
