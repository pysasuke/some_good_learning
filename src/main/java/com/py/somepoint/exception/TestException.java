package com.py.somepoint.exception;

/**
 * @author pysasuke
 * @create 2017-09-05 14:18
 */
/*
注意：
当在try块或catch块中遇到return语句时，finally语句块将在方法返回之前被执行。
在以下4种特殊情况下，finally块不会被执行：
1）在finally语句块中发生了异常。
2）在前面的代码中用了System.exit()退出程序。
3）程序所在的线程死亡。
4）关闭CPU。
 */
/*
1. runtimeException子类:
    1、 java.lang.ArrayIndexOutOfBoundsException
    数组索引越界异常。当对数组的索引值为负数或大于等于数组大小时抛出。
    2、java.lang.ArithmeticException
    算术条件异常。譬如：整数除零等。
    3、java.lang.NullPointerException
    空指针异常。当应用试图在要求使用对象的地方使用了null时，抛出该异常。譬如：调用null对象的实例方法、访问null对象的属性、计算null对象的长度、使用throw语句抛出null等等
    4、java.lang.ClassNotFoundException
    找不到类异常。当应用试图根据字符串形式的类名构造类，而在遍历CLASSPAH之后找不到对应名称的class文件时，抛出该异常。
    5、java.lang.NegativeArraySizeException  数组长度为负异常
    6、java.lang.ArrayStoreException 数组中包含不兼容的值抛出的异常
    7、java.lang.SecurityException 安全性异常
    8、java.lang.IllegalArgumentException 非法参数异常
 */
public class TestException {
    public TestException() {
    }

    boolean testEx() throws Exception {
        boolean ret = true;
        try {
            ret = testEx1();
        } catch (Exception e) {
            System.out.println("testEx, catch com.py.somepoint.exception");
            ret = false;
            throw e;
        } finally {
            System.out.println("testEx, finally; return value=" + ret);
            return ret;
        }
    }

    boolean testEx1() throws Exception {
        boolean ret = true;
        try {
            ret = testEx2();
            if (!ret) {
                return false;
            }
            System.out.println("testEx1, at the end of try");
            return ret;
        } catch (Exception e) {
            System.out.println("testEx1, catch com.py.somepoint.exception");
            ret = false;
            throw e;
        } finally {
            System.out.println("testEx1, finally; return value=" + ret);
            return ret;//false
        }
    }

    boolean testEx2() throws Exception {
        boolean ret = true;
        try {
            int b = 12;
            int c;
            for (int i = 2; i >= -2; i--) {
                c = b / i;
                System.out.println("i=" + i);
            }
            return true;
        } catch (Exception e) {
            System.out.println("testEx2, catch com.py.somepoint.exception");
            ret = false;
            throw e;
        } finally {
            System.out.println("testEx2, finally; return value=" + ret);
            return ret;//false
        }
    }

    public static void main(String[] args) {
        TestException testException1 = new TestException();
        //2 1 testEx2, catch com.py.somepoint.exception
        //testEx2, finally; return value=false
        //testEx1, catch com.py.somepoint.exception  NOT DO IT
        //testEx1, finally; return value=false
        //testEx, catch com.py.somepoint.exception   NOT DO IT
        //testEx, finally; return value=flase

        /*
        注意说明：
        finally语句块不应该出现 应该出现return。上面的return ret最好是其他语句来处理相关逻辑。
         */
        try {
            testException1.testEx();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
