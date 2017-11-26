package com.py.somesuggest.chapter11.no140;

import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.*;
import com.google.common.primitives.Ints;
import org.junit.Test;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 推荐使用Guava扩展工具包
 * Created by Administrator on 2017/11/26 0026.
 */
public class No140 {
    //(1)Collections
    @Test
    public void collectionTest() {
        //1.不可变集合
        //不可变列表
        ImmutableList<String> list = ImmutableList.of("A", "B", "C");
        //不可变Map
        ImmutableMap<Integer, String> map = ImmutableMap.of(1, "壹", 2, "贰", 3, "叁");

        //2.多值Map
        //多值Map
        Multimap<String, String> phoneBook = ArrayListMultimap.create();
        phoneBook.put("张三", "110");
        phoneBook.put("张三", "119");
        System.out.println(phoneBook.get("张三"));    //[110, 119]

        //3.Table表
        Table<Double, Double, String> g = HashBasedTable.create();
        //定义人民广场的经度纬度坐标
        g.put(31.23, 121.48, "人民广场");
        //输出坐标点的建筑物
        System.out.println(g.get(31.23, 121.48));    //人民广场
        //Table，完全类似于数据库表
        Table<Integer, Integer, String> user = HashBasedTable.create();
        //第一行、第一列的值是张三
        user.put(1, 1, "张三");
        //第一行、第二列的值是李四
        user.put(1, 2, "李四");
        //第一行第一列是谁
        System.out.println(user.get(1, 1));    //张三

        //4.集合工具类
        //Lists、Maps、Sets分别对应的是List、Map、Set的工具类
        //姓名、年龄键值对
        Map<String, Integer> userMap = new HashMap<>();
        userMap.put("张三", 20);
        userMap.put("李四", 22);
        userMap.put("王五", 25);
        //所以年龄大于20岁的人员
        Map<String, Integer> filteMap = Maps.filterValues(userMap, new Predicate<Integer>() {
            @Override
            public boolean apply(@Nullable Integer _age) {
                return _age > 20;
            }
        });
    }

    //(2)字符串操作
    @Test
    public void stringTest() {
        //1.Joiner连接器
        //定义连接符号
        Joiner joiner = Joiner.on(",");
        //可以连接多个对象，不局限与String；如果有null，则跳过
        String str = joiner.skipNulls().join("嘿", "Guava很不错哟。");
        Map<String, String> map2 = new HashMap<>();
        map2.put("张三", "普通员工");
        map2.put("李四", "领导");
        //键值之间以“是”连接，多个值以空格分隔
        System.out.println(Joiner.on("\r\n").withKeyValueSeparator("是").join(map2));
        /*
        李四是领导
        张三是普通员工
         */

        //2.Splitter拆分器
        String str2 = "你好，Guava";
        //以“，”中文逗号分隔
        for (String s : Splitter.on("，").split(str2)) {
            System.out.println(s);
        }
        /*
        你好
        Guava
         */
        //按照固定长度分割
        for (String s : Splitter.fixedLength(2).split(str)) {
            System.out.println(s);
        }
        /*
        嘿,
        Gu
        av
        a很
        不错
        哟。
         */
    }

    //(3)基本类型工具
    @Test
    public void baseTest() {
        //以基本类型名+s的方式命名的，比如Ints是int的工具类，Doubles是double的工具类，注意这些都是针对基本类型的，而不是针对包装类型的。
        int[] ints = {10, 9, 20, 40, 80};
        //从数组中取出最大值
        System.out.println(Ints.max(ints));    //80
        List<Integer> integers = new ArrayList<>();
        //把包装类型的集合转为基本类型数据
        ints = Ints.toArray(integers);
        System.out.println(ints.length);    //0
    }

}
