package com.py.somesuggest.chapter8.no113;

import java.util.zip.DataFormatException;

/**
 * 不要在finally块中处理返回值
 *
 * @author Administrator
 * @date 2017/11/13 0013
 * 注意：不要在finally代码块中出现return语句。
 */
public class No113 {
    public static void main(String[] args) {
        try {
            //-1
            System.out.println(doStuff(-1));
            //-1
            System.out.println(doStuff(100));
            //1
            System.out.println(doStuffInt());
            //Person{name='李四'}
            System.out.println(doStuffPerson());
        } catch (Exception e) {
            System.out.println("这里是永远都不会到达的");
        }
    }

    /**
     * 该方法抛出受检异常
     * @param p
     * @return
     * @throws Exception
     */
    public static int doStuff(int p) throws Exception {
        try {
            if (p < 0) {
                throw new DataFormatException("数据格式错误");
            } else {
                return p;
            }
        } catch (Exception e) {
            //异常处理
            throw e;
        } finally {
            /*
            (1)覆盖了try代码块中的return返回值
            (2)异常屏蔽
             */
            return -1;
        }
    }

    public static int doStuffInt() {
        int a = 1;
        try {
            return a;
        } catch (Exception e) {

        } finally {
            //重新修改一下返回值
            a = -1;
        }
        return 0;
    }
    public static Person doStuffPerson(){
        Person person = new Person();
        person.setName("张三");
        try{
            return person;
        }catch (Exception e){

        }finally {
            //重新修改一下返回值
            person.setName("李四");
        }
        person.setName("王五");
        return person;
    }
}
class Person{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}