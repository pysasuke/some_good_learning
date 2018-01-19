package com.py.somesummary.linkedindoit;

import com.py.somepoint.otherneed.Person;

import java.util.HashMap;
import java.util.List;

/**
 * 在初始化的时候预估集合的大小
 *
 * @author pysasuke
 * @create 2017-09-06 13:17
 */
public class InitSize {

    void addObjects1(List<Person> input) {
        HashMap<String, Person> map = new HashMap<>();
        for (Person person : input) {
            map.put(person.getId(), person);
        }

    }

    //在Linkedin实践的时候，常常碰到需要遍历一个 ArrayList 并将这些元素保存到 HashMap 里面去。
    //将这个 HashMap 初始化预期的大小可以避免再次哈希所带来的开销。
    //初始化大小可以设置为输入的数组大小除以默认加载因子的结果值（这里取0.7）：
    void addObjects2(List<Person> input) {
        HashMap<String, Person> map = new HashMap<>((int) Math.ceil(input.size() / 0.7));
        for (Person person : input) {
            map.put(person.getId(), person);
        }

    }
}
