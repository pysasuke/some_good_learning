package com.py.somesuggest.chapter1;

import javax.script.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * 易变业务使用脚本语言编写
 * Created by Administrator on 2017/9/16 0016.
 */
public class NO16 {
    public static void main(String[] args) throws FileNotFoundException, ScriptException, NoSuchMethodException {
        //获得一个JavaScript的执行引擎
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
        //建立上下文变量
        Bindings bind = engine.createBindings();
        bind.put("factor", 1);
        //绑定上下文,作用域是当前引擎范围
        engine.setBindings(bind, ScriptContext.ENGINE_SCOPE);
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int first = input.nextInt();
            int sec = input.nextInt();
            System.out.println("输入参数是：" + first + "," + sec);
            //执行js代码
            engine.eval(new FileReader("e:/model.js"));//如果业务有变更，只需要改变js脚本
            //是否调用方法
            if (engine instanceof Invocable) {
                Invocable in = (Invocable) engine;
                //执行js中的函数
                Double result = (Double) in.invokeFunction("formula", first, sec);
                System.out.println("运算结果：" + result);
            }
        }
    }
}
