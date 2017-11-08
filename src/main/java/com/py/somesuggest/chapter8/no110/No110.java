package com.py.somesuggest.chapter8.no110;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * 提倡异常封装
 * Created by Administrator on 2017/11/8 0008.
 */
public class No110 {
    public static void main(String[] args) throws MyBusinessException {
        doStuff();
    }

    //(1)提高系统的友好性
    public static void doStuff() throws MyBusinessException {
        try {
            InputStream is = new FileInputStream("无效文件.txt");
        } catch (FileNotFoundException e) {
            //为方便开发和维护人员而设置的异常信息
            e.printStackTrace();
            //抛出业务异常
            throw new MyBusinessException("文件不存在");
        }
    }

    //(1)提高系统的可维护性
    public static void doStuff2() throws MyBusinessException {
        try {
            InputStream is = new FileInputStream("无效文件.txt");
            throw new SecurityException("测试");
            //对异常进行分类处理，并进行封装输出
        } catch (FileNotFoundException e) {
            System.out.println("文件未找到，使用默认配置文件...");
        } catch (SecurityException e) {
            System.out.println("无权访问，可能原因是...");
            e.printStackTrace();
        }
    }

    public static void daStuff() throws MyException {
        List<Throwable> list = new ArrayList<>();
        //第一个逻辑片段
        try {
            //Do Something
        } catch (Exception e) {
            list.add(e);
        }
        //第二个逻辑片段
        try {
            //Do Something
        } catch (Exception e) {
            list.add(e);
        }
        //检查是否有必要抛出异常
        if (list.size() > 0) {
            throw new MyException(list);
        }
    }
}

class MyBusinessException extends Exception {
    public MyBusinessException(String message) {
        super(message);
    }
}

class SecurityException extends Exception {
    public SecurityException(String message) {
        super(message);
    }
}

//(3)解决Java异常机制自身的缺陷
//MyException异常只是一个异常容易，可以容纳多个异常，但它本身并不代表任何异常含义，它所解决的是一次抛出多个异常的问题。
class MyException extends Exception {
    //容纳所以的异常
    private List<Throwable> causes = new ArrayList<>();

    //构造函数，传递一个异常列表
    public MyException(List<? extends Throwable> _causes) {
        causes.addAll(_causes);
    }

    //读取所有的异常
    public List<Throwable> getException() {
        return causes;
    }
}