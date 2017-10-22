package com.py.somesuggest.chapter4.no58;

/**
 * 强烈建议使用UTF编码
 * Created by Administrator on 2017/10/22 0022.
 * 注意：一个系统使用同一的编码
 */
public class No58 {
    public static void main(String[] args) throws Exception {
        String str = "汉字";
        //读取字节
        byte[] b = str.getBytes("UTF-8");
        //重新生成一个新的字符串
//        System.out.println(new String(b));    //NOY DO THIS    未明确指定编码
        System.out.println(new String(b,"UTF-8"));
    }
}
