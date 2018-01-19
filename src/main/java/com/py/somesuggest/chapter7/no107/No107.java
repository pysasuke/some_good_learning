package com.py.somesuggest.chapter7.no107;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;

/**
 * 使用反射增加装饰模式的普适性
 *
 * @author Administrator
 * @date 2017/11/7 0007
 */
public class No107 {
    public static void main(String[] args) {
        //定义Jerry这只家喻户晓的老鼠
        Animal jerry = new Rat();
        //为Jerry增加飞行能力
        jerry = new DecorateAnimal(jerry, FlyFeature.class);
        //为Jerry增加挖掘能力
        jerry = new DecorateAnimal(jerry, DigFeature.class);
        //Jerry开始耍猫了
        jerry.doStuff();
        /*
        增加钻地能力
        增加一直翅膀
        Jerry will play with Tom
         */
    }
}

interface Animal {
    public void doStuff();
}

/**
 * 老鼠是一种动物
 */
class Rat implements Animal {

    @Override
    public void doStuff() {
        System.out.println("Jerry will play with Tom");
    }
}

/**
 * 定义某种能力
 */
interface Feature {
    //加载特性
    public void load();
}

/**
 * 飞行能力
 */
class FlyFeature implements Feature {

    @Override
    public void load() {
        System.out.println("增加一直翅膀");
    }
}

/**
 * 钻地能力
 */
class DigFeature implements Feature {

    @Override
    public void load() {
        System.out.println("增加钻地能力");
    }
}

/**
 * 一个装饰类型必然是抽象构建的子类型，它必须要实现doStuff。
 */
class DecorateAnimal implements Animal {
    /**
     * 被包装的动物
     */
    private Animal animal;
    /**
     * 使用哪一个包装器
     */
    private Class<? extends Feature> clz;

    public DecorateAnimal(Animal animal, Class<? extends Feature> clz) {
        this.animal = animal;
        this.clz = clz;
    }

    @Override
    public void doStuff() {
        InvocationHandler handler = new InvocationHandler() {
            //具体包装行为
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object obj = null;
                if (Modifier.isPublic(method.getModifiers())) {
                    obj = method.invoke(clz.newInstance(), args);
                }
                animal.doStuff();
                return obj;
            }

        };
        ClassLoader c1 = getClass().getClassLoader();
        //动态代理，由Handler决定如何包装
        Feature proxy = (Feature) Proxy.newProxyInstance(c1, clz.getInterfaces(), handler);
        proxy.load();

    }
}