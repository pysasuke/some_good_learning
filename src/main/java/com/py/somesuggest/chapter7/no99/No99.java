package com.py.somesuggest.chapter7.no99;

/**
 * 严格限定泛型类型采用多重界限
 * Created by Administrator on 2017/11/4 0004.
 */
//只有上界才有此限定，下界没有多重限定的情况。
public class No99 {
    //使用“&”符号设定多重边界，指定泛型类型T必须是Staff和Passenger的共用子类型。
    public static <T extends Staff & Passenger> void discount(T t) {
        if (t.getSalary() < 2500 && t.isStanding()) {
            System.out.println("恭喜你！您的车票打八折!");
        }
    }

    public static void main(String[] args) {
        discount(new Me());
    }
}

//职员
interface Staff {
    //工资
    public int getSalary();
}

//乘客
interface Passenger {
    //是否是站立状态
    public boolean isStanding();
}

//定义“我”这个类型的人
class Me implements Staff, Passenger {

    @Override
    public boolean isStanding() {
        return true;
    }

    @Override
    public int getSalary() {
        return 2000;
    }
}