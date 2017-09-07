package com.py.somesummary.difficultcheck;

import org.junit.Test;

import java.util.*;

/**
 * @author pysasuke
 * @create 2017-09-05 18:49
 */
public class RunTimeMap {
    @Test
    public void TestM() {
        Map<String, Object> collection = new TreeMap<String, Object>();
        //compute方法通过key在map中查找一个value。如果这个value是null，则插入(key, value)，并返回value

        //因为开始时，这个list是空的，“foo”值并不存在，v是null。然后，我们向map中插入一个“foo”并且“foo”指向new ArrayList<Object>()，此时的ArrayList对象是空的，所以它打印出[]。
        System.out.println(collection.compute("foo",(k,v)->(v==null)?new ArrayList<Object>():((List)v).add("bar")));
        //下一行，“foo”键值存在于map容器中，所以我们计算右边的表达式。ArrayList对象成功转换为List类型，然后“ber”字符串被插入到List中。add方法返回true，因此true就是第二行打印的内容。
        System.out.println(collection.compute("foo",(k,v)->(v==null)?new ArrayList<Object>():((List)v).add("ber")));
    }

}
