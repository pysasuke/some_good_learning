package com.py.somesuggest.chapter7.no108;

/**
 * Created by Administrator on 2017/11/7 0007.
 * 注意：决定使用模板方法模式时，情尝试使用反射方法实现，它会让你的程序更灵活、更强大。
 */
/*
UserPopulator类中的方法只要符合基本方法鉴别器条件即会被模板方法调用，方法的数量也不再受父类约束，
实现了子类灵活定义基本方法、父类批量调用的功能，并且缩减了子类的代码量。
 */
public class UserPopulator extends AbsPopulator {
    /*
    @Override
    protected void doInit() {
        //初始化用户表，如创建、加载数据等
    }
    */
    public void initUser(){
        //初始化用户表，如创建、加载数据等
    }
    public void inirPassword(){
        //初始化密码
    }
    public void initJobs(){
        //初始化工作任务
    }
}
