package com.py.somesuggest.chapter6.no90;

import java.lang.annotation.*;

/**
 * 小心注解继承
 * Created by Administrator on 2017/11/2 0002.
 */
/*
总体上来说，使用@Inherited元注解的弊大于利，特别是一个类的继承层次较深时，
如果注解较多，则很难判断出是哪个注解对子类产生了逻辑劫持。
 */
public class No90 {
    public static void main(String[] args) {
        Bird bird = BirdNest.Sparrow.reproduce();
        Desc.Color color = bird.getColor();
        /*
        因为我们在注解上加了@Inherited，
        它表示的意思是我们只要把注解@Desc加到父类Bird上，它的所有子类都会自动从父类继承@Desc注解，不需要显示声明
         */
        System.out.println("Bird's color is:" + color);    //Bird's color is:White
    }
}

//Retention标识的是该注解的保留级别
@Retention(RetentionPolicy.RUNTIME)
//Target表示的是该注解可以标注在什么地方
@Target(ElementType.TYPE)
//Inherited表示该注解会被自动继承
@Inherited
@interface Desc {
    enum Color {
        White, Grayish, Yellow;
    }

    Color c() default Color.White;
}

@Desc(c = Desc.Color.White)
abstract class Bird {
    //鸟的颜色
    public abstract Desc.Color getColor();
}

class Sparrow extends Bird {
    private Desc.Color color;

    //默认是浅色
    public Sparrow() {
        color = Desc.Color.Grayish;
    }

    public Sparrow(Desc.Color _color) {
        color = _color;
    }

    @Override
    public Desc.Color getColor() {
        return color;
    }
}

//鸟巢，工厂方式模式
enum BirdNest {
    Sparrow;

    //鸟类繁殖
    public Bird reproduce() {
        Desc bd = Sparrow.class.getAnnotation(Desc.class);
        return bd == null ? new Sparrow() : new Sparrow(bd.c());
    }
}