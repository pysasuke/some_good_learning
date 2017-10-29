package com.py.somesuggest.chapter5.no77;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 使用shuffle打乱列表
 * Created by Administrator on 2017/10/29 0029.
 */
public class No77 {
    public static void main(String[] args) {
        int tagCloudNum = 10;
        List<String> tagClouds = new ArrayList<>(tagCloudNum);
        //初始化标签云，一般是从数据库读入
        Random rand = new Random();
//        for (int i = 0; i < tagCloudNum; i++) {
//            //取得随机位置
//            int randomPosition = rand.nextInt(tagCloudNum);
//            //当前元素与随机元素交换
//            String temp = tagClouds.get(i);
//            tagClouds.set(i, tagClouds.get(randomPosition));
//            tagClouds.set(randomPosition, temp);
//        }

//        for (int i = 0; i < tagCloudNum; i++) {
//            //取得随机位置
//            int randomPosition = rand.nextInt(tagCloudNum);
//            //当前元素与随机元素交换
//            Collections.swap(tagClouds, i, randomPosition);
//        }

        //打乱顺序
        Collections.shuffle(tagClouds);
    }
}
