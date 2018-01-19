package com.py.somesuggest.chapter6.no88;

/**
 * 用枚举实现工厂方法模式更简洁
 *
 * @author Administrator
 * @date 2017/10/31 0031
 * 注意：下一次，使用枚举来实现工厂方法模式。
 */
public class No88 {
    public static void main(String[] args) {
        //生产车辆
        Car car = CarFactory.createCar(FordCar.class);
        //(1)避免错误调用的发生(2)性能好，使用便捷(3)降低类间的耦合
//        Car carError = CarFactory.createCar(Car.class);    //NOT DO THIS    //java.lang.InstantiationException: com.py.somesuggest.chapter6.no88.Car
        Car car1 = CarFactory1.BuickCar.create();
        Car car2 = CarFactory2.BuickCar.create();
    }
}

/**
 * 抽象产品
 */
interface Car {

}

/**
 * 具体产品类
 */
class FordCar implements Car {

}

/**
 * 具体产品类
 */
class BuickCar implements Car {

}

/**
 * 工厂类(常用工厂方法模式)
 */
class CarFactory {
    /**
     * 生产汽车
     * @param c
     * @return
     */
    public static Car createCar(Class<? extends Car> c) {
        try {
            return (Car) c.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}

//(1)枚举非静态方法实现工厂方法模式
enum CarFactory1 {
    //定义工厂类能生产汽车的类型
    FordCar, BuickCar;

    //生产汽车
    public Car create() {
        switch (this) {
            case FordCar:
                return new FordCar();
            case BuickCar:
                return new BuickCar();
            default:
                throw new AssertionError("无效参数");
        }
    }
}

//(2)通过抽象方法生成产品
enum CarFactory2 {
    FordCar {
        @Override
        public Car create() {
            return new FordCar();
        }
    },
    BuickCar {
        @Override
        public Car create() {
            return new BuickCar();
        }
    };

    public abstract Car create();
}