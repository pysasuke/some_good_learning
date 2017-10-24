package com.py.somesuggest.chapter5.no68;

/**
 * 频繁插入和删除时使用LinkedList
 * Created by Administrator on 2017/10/24 0024.
 */
/*
ArrayList：
    插入：只要插入一个元素，其后的元素就会向后移动一位，虽然arrayCopy是一个本地方法，效率非常高，
        但频繁的插入，每次后面的元素都要拷贝一遍，效率就变低了，特别是在头位置插入元素时。
    删除：index位置后的元素都要向前移动一位，最后一个位置空出来了，这又是一次数组拷贝，和插入一样，
        如果数据量大，删除动作必然会暴露出性能和效率方面的问题。
    修改：直接替换
LinkedList：
    插入：把自己插入到链表，然后再把前节点的next和后节点的previous指向自己。
    删除：没有任何耗时的操作，全部是引用指针的变更，效率自然高了。
    修改：定位方式会折半遍历，这是一个极耗时的操作。

总结：
    LinkedList的插入效率比ArrayList快50倍以上。
    LinkedList在处理大批量的删除动作时比ArrayList快40倍以上。
    修改元素，在这一点上LinkedList输给了ArrayList
 */
public class No68 {
}
