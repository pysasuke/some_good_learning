package com.py.somesuggest.chapter4.no53;

import junit.framework.Assert;

/**
 * 注意方法中传递的参数要求
 * Created by Administrator on 2017/10/22 0022.
 * 注意：replaceAll传递的第一个参数是正则表达式。
 */
public class No53 {
    public static void main(String[] args) {
        Assert.assertTrue(StringUtils.remove("好是好", "好").equals("是"));
        Assert.assertTrue(StringUtils.remove("$是$", "$").equals("是"));    //失败    replaceAll方法传递的第一个参数是则正表达式
    }
}
