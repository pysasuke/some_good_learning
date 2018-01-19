package com.py.somesuggest.chapter7.no108;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 *
 * @author Administrator
 * @date 2017/11/7 0007
 */
public abstract class AbstractPopulator {
    /*
    //模板方法
    public final void dataInitialing() throws Exception{
        //调用基本方法
        doInit();
    }
    //基本方法
    protected abstract void doInit();
    */

    /**
     * 模板方法
     * @throws Exception
     */
    public final void dataInitialing() throws Exception{
        //获得所以的public方法
        Method[] methods = getClass().getMethods();
        for(Method method:methods){
            //判断是否是数据初始化方法
            if(isInitDataMethod(method)){
                method.invoke(this);
            }
        }
    }

    //判断是否是数据初始化方法，基本方法级别器
    private boolean isInitDataMethod(Method method) {
                //init开头
        return method.getName().startsWith("init")
                //公共方法
                && Modifier.isPublic(method.getModifiers())
                //返回值是void
                && method.getReturnType().equals(Void.TYPE)
                //输入参数为空
                && !method.isVarArgs()
                //不能是抽象方法
                && !Modifier.isAbstract(method.getModifiers());
    }

}
