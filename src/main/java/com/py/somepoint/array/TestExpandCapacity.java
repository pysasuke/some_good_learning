package com.py.somepoint.array;

import org.junit.Test;

/**
 * 数组扩容
 *
 * @author pysasuke
 * @create 2017-09-05 15:32
 */
public class TestExpandCapacity {
    @Test
    public void Test() {
        Object[] intArray = {1, 2, 3, 4, 5};
        try {
            intArray[5] = 7;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("数值下表越界");
            intArray = ArrayUtils.expandCapacity(intArray, 5);
            intArray[5] = 6;
            System.out.println(intArray[5]);
            System.out.println(intArray[6]);
        }


    }
}
