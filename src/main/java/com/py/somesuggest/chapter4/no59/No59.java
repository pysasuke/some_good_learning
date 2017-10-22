package com.py.somesuggest.chapter4.no59;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

/**
 * 对字符串排序持一种宽容的心态
 * Created by Administrator on 2017/10/22 0022.
 * 注意：如果排序不一个关键算法，使用Collator类即可。
 */
public class No59 {
    public static void main(String[] args) {
//        String[] strs = {"张三(Z)", "李四(L)", "王五(W)"};
        String[] strs ={"犇(B)","鑫(X)"};
        //排序，默认是升序
//        Arrays.sort(strs);

        //定义一个中文排序器
        /*
        如果排序对象是经常使用的汉字，使用Collator类排序完全可以满足我们的要求，
        如果需要严格排序，则需要使用一些开源项目来自己实现了，
        比如pinyin4j可以把汉子转换为拼音，然后我们自己来实现排序算法，
        不过此时你也会发现要考虑诸如算法、同音字、多音字等众多问题。
         */

        Comparator c = Collator.getInstance(Locale.CHINA);
        //升序排列
        Arrays.sort(strs, c);
        int i = 0;
        for (String str : strs) {
            System.out.println((++i) + "、" + str);
        }
    }
}
