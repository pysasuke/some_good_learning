package com.py.somesummary.javapuzzler;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

/**
 * java解惑
 * @author pysasuke
 * @create 2017-09-06 15:33
 */
public class JavaPuzzlerTest {
    /**
     * 奇偶判断
     */
    @Test
    public void oddEven() {
        int i = 9;
        i = -3;
        /*
        if(i % 2 == 1){    //NOT DO THIS 因为i为负奇数时不成立
            System.out.println("是奇数");
        }
        */
        if (i % 2 != 0) {
            System.out.println("是奇数");
        }
        //-1
        System.out.println(-1 % 2);
        //-1
        System.out.println(-3 % 2);
        //-1
        System.out.println(-5 % 2);
    }

    /**
     * 小数精确计算
     */
    @Test
    public void decimalPrecision() {
        //问题在于1.1这个数字不能被精确表示为一个double，因此它被表示为最接近它的double值，
        // 该程序从2中减去的就是这个值，但这个计算的结果并不是最接近0.9的double值
        //0.8999999999999999
        System.out.println(2.00 - 1.10);
        // 0.90
        System.out.println(new BigDecimal("2.0").subtract(new BigDecimal("1.10")));
    }

    @Test
    public void intOverflow() {
        //问题在于计算过程中溢出了。这个计算式完全是以int运算来执行的，并且只有在运算完成之后，
        // 其结果才被提升为long，而此时已经太迟：计算已经溢出。
        /*
        long microsPerDay = 24 * 60 * 60 * 1000 * 1000;  //NOT DO THIS 正确结果应为：86400000000
        System.out.println(microsPerDay);  // 实际上为：500654080
        */
        //解决方法使计算表达式的第一个因子明确为long型，这样可以强制表达式中所有的后续计算都用long运算来完成，这样结果就不会溢出
        long microsPerDay = 24L * 60 * 60 * 1000 * 1000;
        // 86400000000
        System.out.println(microsPerDay);
    }

    /**
     * 数值溢出
     */
    @Test
    public void valueOverflow() {
        short x = 0;
        int i = 123456;
        //复合赋值表达式自动地将所执行计算的结果转型为其左侧变量的类型
        //如果结果的类型比该变量的类型要宽，那么复合赋值操作符将悄悄地执行一个窄化原生类型转换，这样就会导致结果不正确
        /*
        请不要将复合赋值操作符作用于byte、short或char类型的变量；
        在将复合赋值操作符作用于int类型的变量时，要确保表达式右侧不是long、float或double类型；
        在将复合赋值操作符作用于float类型的变量时，要确保表达式右侧不是double类型。
        其实一句：不要将让左侧的类型窄于右侧的数字类型。
         */
        //NOT DO THIS
        x += i;
        //-7616
        System.out.println(x);
    }

    /**
     * i++相关
     */
    @Test
    public void plusPlus() {
        int i = 0, j = 0, y = 0;
        //相当于：i=i+1;
        i++;
        // i=1
        System.out.println("i=" + i);
        //相当于：i=i+1;
        ++i;
        // i=2
        System.out.println("i=" + i);
        //相当于：int tmp=i;i=i+1;i=tmp;
        i = i++;
        // i=2
        System.out.println("i=" + i);
        //编译时出现警告，与i=i;警告相同。相当于：i=i+1;i=i;
        i = ++i;
        // i=3
        System.out.println("i=" + i);
        //相当于：int tmp=i;i=i+1;j=tmp;
        j = i++;
        // j=3
        System.out.println("j=" + j);
        // i=4
        System.out.println("i=" + i);
        //相当于：i=i+1;y=i;
        y = ++i;
        // y=5
        System.out.println("y=" + y);
        // i=5
        System.out.println("i=" + i);
    }

    /**
     * 奇怪的
     */
    @Test
    public void queer() {
        //-2147483648
        System.out.println(Integer.MAX_VALUE + 1);
        // NaN
        System.out.println(0.0 / 0.0);
        //NaN false
        System.out.println(Double.NaN + " " + (Double.NaN == (0.0 / 0.0)));
        // false
        System.out.println(new Integer(0) == new Integer(0));
        //自动拆箱
        // true
        System.out.println(new Integer(0) == 0);
        // -2147483648
        System.out.println(Math.abs(Integer.MIN_VALUE));
        //当且仅当+操作符的操作数中至少有一个是String类型时，才会执行字符串连接操作；否则，执行加法。
        //162
        System.out.println('a' + 'A');
    }

    /**
     * 三个bug
     */
    @Test
    public void threeBug() {
        Random rnd = new Random();
        StringBuffer word ;
        //rnd.nextInt(2)只会返回0、1 两个数字
        switch (rnd.nextInt(2)) {
            //实质上运行时将字符型转换成了int型，这样将字符当作StringBuffer的初始容量了，而不是字符本身
            case 1:
                word = new StringBuffer('P');
            case 2:
                word = new StringBuffer('G');
            default:
                //每次都会执行default分支语句
                word = new StringBuffer('M');
        }
        word.append('a');
        word.append('i');
        word.append('n');
        //ain
        System.out.println(word);
    }

    @Test
    public void threeBugModify() {
        Random rnd = new Random();
        StringBuffer word;
        switch (rnd.nextInt(3)) {
            case 1: {
                word = new StringBuffer("P");
                break;
            }
            case 2: {
                word = new StringBuffer("G");
                break;
            }
            default: {
                word = new StringBuffer("M");
                break;
            }
        }
        word.append('a');
        word.append('i');
        word.append('n');
        //Gain
        System.out.println(word);
    }

    /**
     * 不可变的引用
     */
    @Test
    public void finalQuote() {
        /*
        BigInteger实例是不可变的。
        String、BigDecimal以及包装类型：Integer、Long、Short、Byte、Character、Boolean、Float和Double也是如此。
        对这些类型的操作将返回新的实例。
         */

        BigInteger total = BigInteger.ZERO;
//        total.add(new BigInteger("1"));    //NOT DO THIS
//        total.add(new BigInteger("10"));    //NOT DO THIS
//        System.out.println(total);//0
        total = total.add(new BigInteger("1"));
        total = total.add(new BigInteger("10"));
        //11
        System.out.println(total);
    }
}
