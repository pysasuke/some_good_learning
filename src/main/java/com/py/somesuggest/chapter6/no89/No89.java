package com.py.somesuggest.chapter6.no89;

import java.util.EnumSet;

/**
 * 枚举项的数量限制在64个以内
 * Created by Administrator on 2017/11/2 0002.
 * 注意：枚举项数量不要超过64，否则建议拆分
 */
/*
RegularEnumSet是把每个枚举项编码映射到一个long类型数字的每一个位上，
JumboEnumSet是先按照64个一组进行拆分，然后每个组再映射到一个long类型数字的每一个位上。
 */
public class No89 {
    public static void main(String[] args) {
        //创建包含所有枚举项的EnumSet
        //allOf：当枚举数量小于等于64时，创建一个RegularEnumSet实例对象，大于64时则创建一个JumboEnumSet实例对象
        EnumSet<Const> cs = EnumSet.allOf(Const.class);
        EnumSet<LargeConst> lcs = EnumSet.allOf(LargeConst.class);
        //打印出所有枚举项数量
        System.out.println("Const枚举项数量：" + cs.size());    //Const枚举项数量：64
        System.out.println("LargeConst枚举项数量：" + lcs.size());    //LargeConst枚举项数量：65
        //输出两个EnumSet的class
        System.out.println(cs.getClass());    //class java.util.RegularEnumSet
        System.out.println(lcs.getClass());    //class java.util.JumboEnumSet
    }
}
//普通枚举项，数量等于64
enum Const {
    A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z,
    AA, BB, CC, DD, EE, FF, GG, HH, II, JJ, KK, LL, MM, NN, OO, PP, QQ, RR, SS, TT, UU, VV, WW, XX, YY, ZZ,
    AAA, BBB, CCC, DDD, EEE, FFF, GGG, HHH, III, JJJ, KKK, LLL;
}
//大枚举，数量超过64
enum LargeConst {
    A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z,
    AA, BB, CC, DD, EE, FF, GG, HH, II, JJ, KK, LL, MM, NN, OO, PP, QQ, RR, SS, TT, UU, VV, WW, XX, YY, ZZ,
    AAA, BBB, CCC, DDD, EEE, FFF, GGG, HHH, III, JJJ, KKK, LLL, MMM;
}