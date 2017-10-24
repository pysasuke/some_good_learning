package com.py.somesuggest.chapter5.no67;

import org.junit.Test;

import java.util.*;

/**
 * 不同的列表选择不同的遍历方法
 * Created by Administrator on 2017/10/24 0024.
 * 注意：列表遍历不是那么简单的，其中很有“学问”，适时选择最优的便利方式，不要固化为一种。
 */
public class No67 {
    public static void main(String[] args) {

    }

    @Test
    public void testArrayList() {
        //学生数量，80万
        int stuNum = 80 * 10000;
        //List集合，记录所有学生的分数
        List<Integer> scores = new ArrayList<>(stuNum);
        //写入分数
        for (int i = 0; i < stuNum; i++) {
            scores.add(new Random().nextInt(150));
        }
        test(scores);
        /*
        平均分是：74
        执行时间：20ms
        平均分是：74
        执行时间：12ms
         */
    }

    @Test
    public void testLinkedList() {
        //学生数量，80万
        int stuNum = 80 * 10000;
        //List集合，记录所有学生的分数
        List<Integer> scores = new LinkedList<>();
        //写入分数
        for (int i = 0; i < stuNum; i++) {
            scores.add(new Random().nextInt(150));
        }
        test(scores);

    }

    //计算平均数
    public static int average1(List<Integer> list) {
        int sum = 0;
        //遍历求和
        /*
        foreach与以下代码等价：
        for(Iterator<Integer> i = list.iterator;i.hasNext();){
                sum+=sum
         }
         */
        for (int i : list) {
            sum += i;
        }
        //除以人数，计算平均值
        return sum / list.size();
    }

    //计算平均数
    public static int average2(List<Integer> list) {
        int sum = 0;
        //遍历求和
        for (int i = 0, size = list.size(); i < size; i++) {
            sum += list.get(i);
        }
        //除以人数，计算平均值
        return sum / list.size();
    }

    private void test(List<Integer> scores) {

        //记录开始计算时间
        long start = System.currentTimeMillis();
        System.out.println("平均分是：" + average1(scores));    //平均分是：74
        long end = System.currentTimeMillis();
        System.out.println("执行时间：" + (end - start) + "ms");    //执行时间：26ms
        //记录开始计算时间
        start = System.currentTimeMillis();
        System.out.println("平均分是：" + average2(scores));    //平均分是：74
        end = System.currentTimeMillis();
        System.out.println("执行时间：" + (end - start) + "ms");    //执行时间：17ms
    }

    //计算平均数
    public static int average(List<Integer> list) {
        int sum = 0;
        //遍历求和
        //如果可以随机存取，则使用下标遍历
        if (list instanceof RandomAccess) {
            for (int i = 0, size = list.size(); i < size; i++) {
                sum += list.get(i);
            }
        } else {
            //有序存取，使用foreach方式
            for (int i : list) {
                sum += i;
            }
        }
        //除以人数，计算平均值
        return sum / list.size();
    }

}
