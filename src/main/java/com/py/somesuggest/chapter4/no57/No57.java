package com.py.somesuggest.chapter4.no57;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 推荐在复杂字符串操作中使用正则表达式
 * Created by Administrator on 2017/10/22 0022.
 * 注意：正则表达式是恶魔，威力巨大，但难以控制
 */
public class No57 {
    public static void main(String[] args) {
        //接收键盘输入
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String str = input.nextLine();
            //使用split方法分隔后统计
//            int wordsCount = str.split(" ").length;
//            System.out.println(str + "单词数：" + wordsCount);
            //正则表达式对象
            /*
            Java的正则表达式中"\b"表示的是一个单词的边界，它是一个位置界定符，一边为字符或者数字，另一边则非字符或者数字
            "\w"表示的是字符或者数字
             */

            Pattern pattern = Pattern.compile("\\b\\w+\\b");
            //生成匹配器
            Matcher matcher = pattern.matcher(str);
            //记录单词数量
            int wordsCount = 0;
            //遍历查找匹配，统计单词数量
            while(matcher.find()){
                wordsCount++;
            }
            System.out.println(str + "单词数：" + wordsCount);
        }
    }
}
