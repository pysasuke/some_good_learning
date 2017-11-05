package com.py.somesuggest.chapter7.no98;

/**
 * 建议采用的顺序是List<T>、List<?>、List<Object>
 * Created by Administrator on 2017/11/4 0004.
 */
/*
1、List<T>是确定的某一个类型
2、List<T>可以进行读写操作
    List<T>可以进行诸如add、remove等操作，因为它的类型是固定的T类型，在编码期不需要进行任何的转型操作。
    List<?>是只读类型，不能进行增加、修改操作，但是可以执行诸如remove、clear等方法，因为它的删除与反省类型无关。
    List<Object>也可以读写操作，但是它执行写入操作需要向上转型，在读取数据后需要向下转型，而此时已经失去了泛型存在的意义了。
 */
//推而广之，Dao<T>应该比Dao<?>、Dao<Object>更显采用，Desc<Person>则比Desc<?>、Desc<Object>更优先采用。
public class No98 {
}
