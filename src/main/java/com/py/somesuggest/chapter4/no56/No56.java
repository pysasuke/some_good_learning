package com.py.somesuggest.chapter4.no56;

/**
 * 自由选择字符串拼接方法
 *
 * @author Administrator
 * @date 2017/10/22 0022
 * 注意：适当地场景使用适当地字符串拼接方式
 */
public class No56 {
    public static void main(String[] args) {
        //1658
        doWithAdd();
        //478
        doWithConcat();
        //7
        doWithStringBuffer();
        //6
        doWithStringBuilder();
    }

    public static String doWithStringBuilder() {
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < 50000; i++) {
            sb.append("c");
        }
        String str = sb.toString();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return str;
    }

    public static String doWithStringBuffer() {
        long start = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < 50000; i++) {
            sb.append("c");
        }
        String str = sb.toString();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return str;
    }

    /*
    "+"号拼接代码与如下代码相同：
    str = new StringBuilder(str).append("c").toString;
    注意：它与纯粹使用StringBuilder的append方法不同：
        一是每次循环都会创建一个StringBuilder对象
        二是每次执行完毕都要调用toString方法将其转换为字符串，它的执行时间就是耗费在这里了
     */
    public static String doWithAdd() {
        long start = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < 50000; i++) {
            str = str + "c";
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return str;
    }
    /*
    注意：每次concat操作都会新创建一个String对象，这就是concat速度慢下来的正在原因
     */
    public static String doWithConcat() {
        long start = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < 50000; i++) {
            str = str.concat("c");
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return str;
    }
}
