package com.py.somesuggest.chapter2.no30;

import java.util.Random;

/**
 * Created by Administrator on 2017/9/18 0018.
 */
public class Example {
    public static void main(String[] args) {
        //显示地设置了随机种子为1000，运行多次，虽然实例不同，但都会获得相同的三个随机数
        Random r = new Random(1000);  //NOT DO THIS
        for (int i = 1; i < 4; i++) {
            System.out.println("第" + i + "次:" + r.nextInt());
        }
    }
}
