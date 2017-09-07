package com.py.somesummary.difficultcheck;

import com.google.common.collect.Sets;
import com.py.somepoint.otherneed.Person;

import java.util.Set;

/**
 * google guava包相关
 * @author pysasuke
 * @create 2017-09-05 17:22
 */
public class GoogleSetsLook {

    //真正的问题在于，这段代码很有可能造成内存用尽的异常（out of memory com.py.somepoint.exception）。
    //这个循环实际上是没有边界的，所以我们可以不停地往set中添加person对象，直到内存用尽。
    public static Set<Person> getBestFriendsClique(Person person) {
        Set<Person> result = Sets.newHashSet(person);
        //最后这部分有一点微妙，我们不能向这个Set集合添加重复的元素，即person对象，所以这个方法并不会导致无限循环。
        while ((person.bestFriend != null) && (result.add(person.bestFriend))) {
            person = person.bestFriend;
        }
        return result;
    }
}

