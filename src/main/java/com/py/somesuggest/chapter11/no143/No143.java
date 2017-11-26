package com.py.somesuggest.chapter11.no143;

import ch.lambdaj.Lambda;
import gnu.trove.decorator.TIntListDecorator;
import gnu.trove.function.TIntFunction;
import gnu.trove.list.TIntList;
import gnu.trove.list.array.TIntArrayList;
import gnu.trove.map.TIntObjectMap;
import gnu.trove.map.hash.TIntObjectHashMap;
import gnu.trove.procedure.TIntProcedure;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import lombok.Data;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 可以选择多种Collections扩展
 * Created by Administrator on 2017/11/26 0026.
 */
public class No143 {
    @Test
    public void test() {
        //fastutil
        fastUtilTest();
        //trove
        troveTest();
        //lambdaj
        lambdajTest();
    }

    //fastutil提供的Big系列的集合，它的最大容量是Long的最大值
    private void fastUtilTest() {
        //明确键类型的Map
        Int2ObjectMap<String> map = new Int2ObjectOpenHashMap();
        map.put(100, "A");
        System.out.println(map);    //{100=>A}
        //超大容量的List，注意调整JVM的Heap内存
//        BigList<String> bigList = new ObjectBigArrayBigList<>(1L + Integer.MAX_VALUE);
        //基本类型的集合，不再使用Integer包装类型
    }

    private void troveTest() {
        //基本类型的集合，不使用包装类型
        TIntList intList = new TIntArrayList();
        intList.add(1000);
        intList.add(2000);
        //每个元素乘以2
        intList.transformValues(new TIntFunction() {
            public int execute(int element) {
                return element * 2;
            }
        });
        System.out.println(intList);    //{2000, 4000}
        //过滤，把大于200的元素组成一个新的列表
        TIntList t2 = intList.grep(new TIntProcedure() {
            public boolean execute(int _element) {
                return _element > 200;
            }
        });
        System.out.println(t2);    //{2000, 4000}
        //包装为JDK的List
        List<Integer> list = new TIntListDecorator(intList);
        //键类型确定的Map
        TIntObjectMap<String> map = new TIntObjectHashMap();
    }

    private void lambdajTest() {
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        //计算平均值
        System.out.println(Lambda.avg(ints));    //1
        //统计每个元素出现的次数，返回的是一个Map
        System.out.println(Lambda.count(ints));    //{1=1, 2=1}
        //按照年龄排序
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("张三", 30));
        persons.add(new Person("李四", 20));
        Lambda.sort(persons, Lambda.on(Person.class).getAge());
        //串联所以元素的指定属性，输出为张三，李四，王五
        System.out.println(Lambda.joinFrom(persons).getName());    //张三, 李四
        //过滤出年纪大于20岁的所有元素，输出为一个子表
        System.out.println(Lambda.select(persons, new BaseMatcher<Person>() {
            @Override
            public void describeTo(Description description) {

            }

            @Override
            public boolean matches(Object _person) {
                Person p = (Person) _person;
                return p.getAge() > 20;
            }
        }));
        /*
        [Person(age=30, name=张三)]
         */
        //查找出最大年龄
        System.out.println(Lambda.maxFrom(persons).getAge());    //30
        //抽取出所有姓名形成一个数组
        System.out.println(Lambda.extract(persons, Lambda.on(Person.class).getName()));    //[张三, 李四]
    }
}

@Data
class Person {
    private int age;
    private String name;

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }
}
