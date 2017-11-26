package com.py.somesuggest.chapter11.no142;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Hours;
import org.joda.time.MutableDateTime;
import org.joda.time.format.DateTimeFormat;
import org.junit.Test;

import java.util.Date;
import java.util.Locale;

/**
 * 推荐使用Joda日期时间扩展包
 * Created by Administrator on 2017/11/26 0026.
 */
/*
DateTime是一个不可变类型，与String非常相似，即使通过plusXXX、minusXX等方法进行操作，dt对象仍然不会变，只是新生成一个DateTime对象而已
但是Joda也提供了一个可变类型的日期对象：MutableDateTime类
 */
public class No142 {
    @Test
    public void jodaTest() {
        //(1)本地格式的日期时间
        localTimeTest();
        //(2)日期计算
        dateCalTest();
        //(3)时区时间
        zoneTimeTest();
    }

    private void localTimeTest() {
        //当前时间戳
        DateTime dt = new DateTime();
        System.out.println(dt);    //2017-11-26T21:53:19.206+08:00
        //输出英文日期
        System.out.println(dt.dayOfWeek().getAsText(Locale.ENGLISH));    //Sunday
        //本地日期格式
        System.out.println(dt.toLocalDate());    //2017-11-26
        //日期格式化
        System.out.println(dt.toString(DateTimeFormat.forPattern("yyyy年M月d日")));    //2017年11月26日
    }

    private void dateCalTest() {
        //当前时间戳
        DateTime dt = new DateTime();
        //加100小时是星期几
        System.out.println(dt.plusHours(100).dayOfWeek().getAsText());    //星期五
        //100天后的日期
        System.out.println(dt.plusDays(100).toLocalDate());    //2018-03-06
        //10年前的今天是星期几
        System.out.println(dt.minusYears(10).dayOfWeek().getAsText());    //星期一
        //离某个时间还有多少小时
        System.out.println(Hours.hoursBetween(dt, new DateTime("2017-12-21")).getHours());    //578

        //当前可变时间
        MutableDateTime mdt = new MutableDateTime();
        //10年后的日期
        DateTime destDateTime = dt.plusYears(10);
        while (mdt.isBefore(destDateTime)) {
            //循环一次加1天
            mdt.addDays(1);
            //是13号，并且是星期五
            if (mdt.getDayOfMonth() == 3 && mdt.getDayOfWeek() == 5) {
                //打印出10年内所有的黑色星期五
                System.out.println("黑色星期五:" + mdt);
            }
            /*
            黑色星期五:2018-08-03T22:04:15.010+08:00
            黑色星期五:2019-05-03T22:04:15.010+08:00
            黑色星期五:2020-01-03T22:04:15.010+08:00
            黑色星期五:2020-04-03T22:04:15.010+08:00
            黑色星期五:2020-07-03T22:04:15.010+08:00
            黑色星期五:2021-09-03T22:04:15.010+08:00
            黑色星期五:2021-12-03T22:04:15.010+08:00
            黑色星期五:2022-06-03T22:04:15.010+08:00
            黑色星期五:2023-02-03T22:04:15.010+08:00
            黑色星期五:2023-03-03T22:04:15.010+08:00
            黑色星期五:2023-11-03T22:04:15.010+08:00
            黑色星期五:2024-05-03T22:04:15.010+08:00
            黑色星期五:2025-01-03T22:04:15.010+08:00
            黑色星期五:2025-10-03T22:04:15.010+08:00
            黑色星期五:2026-04-03T22:04:15.010+08:00
            黑色星期五:2026-07-03T22:04:15.010+08:00
            黑色星期五:2027-09-03T22:04:15.010+08:00
             */
        }
    }

    private void zoneTimeTest() {
        //当前时间戳
        DateTime dt = new DateTime();
        //此时伦敦市的时间
        System.out.println(dt.withZone(DateTimeZone.forID("Europe/London")));    //2017-11-26T14:07:50.460Z
        //计算出标准时间
        System.out.println(dt.withZone(DateTimeZone.UTC));    //2017-11-26T14:07:50.460Z

        //Joda的DateTime转为JDK的Date
        Date jdkDate = dt.toDate();
        //JDK的Date转为Joda的DateTime
        dt = new DateTime(jdkDate);
    }


}
