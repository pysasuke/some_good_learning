package com.py.somesuggest.chapter1.no15;

/**
 * break万万不能忘
 *
 * @author Administrator
 * @date 2017/9/16 0016
 */
public class No15 {
    public static void main(String[] args) {
        System.out.println("2 = " + toChineseNumberCase(2));
    }

    public static String toChineseNumberCase(int n) {
        String chineseNumber = "";
        switch (n) {
            case 0:
                chineseNumber = "零";
                break;//应该加上
            case 1:
                chineseNumber = "壹";
                break;
            case 2:
                chineseNumber = "贰";
                //如果没有break，匹配之后的赋值语句都会被执行，值会被最后一个赋值语句覆盖(变成玖)
                break;//应该加上
            case 3:
                chineseNumber = "叁";
                break;
            case 4:
                chineseNumber = "肆";
                break;
            case 5:
                chineseNumber = "伍";
                break;
            case 6:
                chineseNumber = "陆";
                break;
            case 7:
                chineseNumber = "柒";
                break;
            case 8:
                chineseNumber = "捌";
                break;
            case 9:
                chineseNumber = "玖";
                break;

//            default://我的看法：应该加上
//                throw new RuntimeException("没有匹配的情况");
        }
        return chineseNumber;
    }
}
