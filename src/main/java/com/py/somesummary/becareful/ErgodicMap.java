package com.py.somesummary.becareful;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by pysasuke on 2017/7/25.
 * 遍历map
 */
public class ErgodicMap {
    public static void main(String[] args) {
        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("111", "222");
        Set<Map.Entry<String, String>> entrySet = hm.entrySet();
        //如果你只是想遍历一下这个Map的key值，那用”Set keySet = hm.keySet();”会比较合适一些
        Iterator<Map.Entry<String, String>> iter = entrySet.iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> entry = iter.next();
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }
}
