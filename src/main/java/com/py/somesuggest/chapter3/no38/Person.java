package com.py.somesuggest.chapter3.no38;

/**
 * Created by Administrator on 2017/10/9 0009.
 */
/*
静态内部类与普通内部类的区别：
1.静态内部类不持有外部类的引用
    在普通内部类中，我们可以直接访问外部类的属性、方法，即使是private类型也可以访问，
    这是因为内部类持有一个外部类的引用，可以自由访问。
    而静态内部类，则只可以访问外部类的静态方法和静态属性(如果是private权限也能访问，这是由
    其代码位置所决定的)，其他的则不能访问。
2.静态内部类不依赖外部类
    普通内部类与外部类之间是相互依赖的关系，内部类实例不能脱离外部类实例，也就是说
    他们会同生同死，一起声明，一起被垃圾回收器回收。
    而静态内部类是可以独立存在的，即使外部类消亡了，静态内部类还是可以存在的。
3.普通内部类不能声明static的方法和变量
    普通内部类不能声明static的方法和变量，注意这里说的是变量，常量(也就是final static修饰的属性)
    还是可以的，而静态内部类形似外部类，没有任何限制。
 */
public class Person {
    //姓名
    private String name;
    //家庭
    private Home home;

    //构造函数设置属性值
    public Person(String _name) {
        name = _name;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class Home {
        //家庭住址
        private String address;
        //家庭电话
        private String tel;

        public Home(String _address, String _tel) {
            address = _address;
            tel = _tel;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }
    }
}
