package com.py.somesuggest.chapter6.no85;

/**
 * 小心switch带来的空值异常
 *
 * @author Administrator
 * @date 2017/10/31 0031
 */
public class No85 {
    public static void main(String[] args) {
        //Exception in thread "main" java.lang.NullPointerException
        doSport(null);
    }

    /*
    编译时，编译器判断出switch语句后的参数是枚举类型，然后就会根据枚举的排序值继续匹配
     */
    public static void doSport(Season season) {
        if (null == season) {
            System.out.println("参数为null");
            return;
        }
        switch (season) {
//        switch (season.ordinal()) {    //与上面代码相同
            case Spring:
                System.out.println("春天放风筝");
                break;
            case Summer:
                System.out.println("夏天游泳");
                break;
            case Autumn:
                System.out.println("秋天捉知了");
                break;
            case Winter:
                System.out.println("冬天滑冰");
                break;
            default:
                System.out.println("输入错误！");
                break;
        }
    }
}

enum Season {
    Spring, Summer, Autumn, Winter
}