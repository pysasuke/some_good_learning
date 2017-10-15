package com.py.somesuggest.chapter_3.no31;

/**
 * 在接口中不要存在实现代码
 * 注意：接口中不能存在现实代码
 * Created by Administrator on 2017/9/19 0019.
 */
public class NO31 {
    public static void main(String[] args) {
//        B.s.doSomething();
    }

    //在接口中存在实现代码
    interface B {
        //如果把实现代码写到接口中，那接口就绑定了可能变化的元素，这就会导致实现不再稳定和可靠，是随时都可能被抛弃、被更改、被重构的
//        public static final S s = new S() {    //NOT DO THIS
//            @Override
//            public void doSomething() {
//                System.out.println("我在接口中实现了");
//            }
//        };
    }

    //被实现的接口
    interface S {
        public void doSomething();
    }
}
