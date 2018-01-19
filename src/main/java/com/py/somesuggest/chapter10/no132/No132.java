package com.py.somesuggest.chapter10.no132;

/**
 * 提升Java性能的基本方法
 *
 * @author Administrator
 * @date 2017/11/21 0021
 */
/*
(1)不要在循环条件中计算
    如果在循环(如for循环、while循环)条件中计算，则每循环一遍就要计算一次，这会降低系统效率
(2)尽可能把变量、方法声明为final static类型
(3)缩小变量的作用范围
    关于变量，能定义在方法内就定义在方法内，能定义在一个循环体内就定义在循环体内，能放置在一个try-catch快内的就放置在该块内，其目的是加快GC的回收。
(4)频繁字符串操作使用StingBuilder或StringBuffer
(5)使用非线性检索
    如果在ArrayList中存储了大量的数据，使用indexOf查找元素会比java.utils.Collections.binarySearch的效率低很多，原因是binarySearch是二分搜索法，而indexOf使用的是逐个元素比对的方法。这里要注意：使用binarySearch搜索时，元素必须进行排序，否则准确性就不可靠了。
(6)覆写Exception的fillInStackTrace方法
    fillInStackTrace方法是用来记录异常时的栈信息的，这是非常耗时的动作，如果我们在开发时不需要关注栈信息，则可以覆盖之，如下覆盖fillInStackTrace的自定义异常会使性能提升10倍以上:
        class MyException extends Exception{
            public Throwable fillInStackTrace(){
                return this;
            }
        }
(7)不建立冗余对象
    需要的时候才创建对象
 */
public class No132 {
}
