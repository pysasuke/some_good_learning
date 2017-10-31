package com.py.somesuggest.chapter6.no84;

/**
 * 使用构造函数协助描述枚举项
 * Created by Administrator on 2017/10/31 0031.
 */
/*
除了排序号外，枚举还有一个或多个属性：枚举描述，它的含义是通过枚举的构造函数，声明每个枚举项(也就是枚举的实例)必须具有的属性和行为，
这是对枚举项的描述或补充，目的是使枚举项表述的意义更加清晰准确。
 */
public class No84 {
}

enum Season {
    Spring("春"), Summner("夏"), Autumn("秋"), Winter("冬");
    private String desc;

    Season(String _desc) {
        desc = _desc;
    }

    //获得枚举描述
    public String getDesc() {
        return desc;
    }
}

enum Role {
    Admin("管理员", new Lifetime(), new Scope()),
    User("普通用户", new Lifetime(), new Scope());
    //中文描述
    private String name;
    //角色的生命期
    private Lifetime lifetime;
    //权限范围
    private Scope scope;

    Role(String _name, Lifetime _lt, Scope _scope) {
        name = _name;
        lifetime = _lt;
        scope = _scope;

    }
}

class Lifetime {

}

class Scope {

}