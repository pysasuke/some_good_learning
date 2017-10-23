package com.py.somesuggest.chapter5.no62;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Arrays;

/**
 * 警惕数组的浅拷贝
 * Created by Administrator on 2017/10/23 0023.
 */
//通过copyOf方法产生的数组是一个浅拷贝：基本类型是直接拷贝值，其他都是拷贝引用地址
public class No62 {
    public static void main(String[] args) {
        //气球数量
        int ballonNum = 7;
        //第一个箱子
        Balloon[] box1 = new Balloon[ballonNum];
        for (int i = 0; i < ballonNum; i++) {
            box1[i] = new Balloon(Color.values()[i], i);
        }
        //第二个箱子的气球是拷贝的第一个箱子里的
        Balloon[] box2 = Arrays.copyOf(box1, box1.length);
        //修改最后一个气球颜色
        box2[6].setColor(Color.Blue);
        System.out.println(box1[6]);    //com.py.somesuggest.chapter5.no62.Balloon@78308db1[编号=6,颜色=Blue]
    }
}

//气球颜色
enum Color {
    Red, Orange, Yellow, Green, Blue, Indigo, Biolet;
}

//气球
class Balloon {
    //编号
    private int id;
    //颜色
    private Color color;

    public Balloon(Color _color, int _id) {
        color = _color;
        id = _id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    //apache-common包下的ToStringBuilder重写toString方法
    public String toString() {
        return new ToStringBuilder(this).append("编号", id).append("颜色", color).toString();
    }
}