package com.py.somesummary.linkedindoit;

import org.junit.Test;
import com.py.somepoint.otherneed.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * 谨慎对待Java的循环遍历
 * @author pysasuke
 * @create 2017-09-06 11:19
 */
public class LoopTraverseTest {
    private final List<Person> personList = new ArrayList<Person>(10);

    //实际上这里还是需要一些权衡的。代码A使用了迭代器，保证了在获取元素的时候的时间复杂度是 O(1) （使用了 getNext() 和 hasNext() 方法），最终的时间复杂度为 O(n) 。
    //但是对于代码B，循环里每次在调用 personList.get(i) 的时候花费的时间复杂度为 O(n)
    //(假设这个list为一个 LinkedList)，那么最终代码B整个循环的时间复杂度就是 O(n^2)
    //(但如果代码B里面的list是 ArrayList， 那 get(i) 方法的时间复杂度就是 O(1)了)。
    //所以在决定使用哪一种遍历的方式的时候，我们需要考虑列表的底层实现，列表的平均长度以及所使用的内存。
    //最后因为我们需要优化内存，再加上 ArrayList 在大多数情况下查找的时间复杂度为 O(1) ，最后决定选择代码B所使用的方法。
    public void test1(){
        for (Person person : personList) { /*Do*/
            //doSomething
        }
    }
    @Test
    public void test2(){
        int size = personList.size();
        personList.add(new Person());
        for (int i = 0; i < size; i++) {
            Person person = personList.get(i); /*Do*/
            //doSomething
        }
    }
}
