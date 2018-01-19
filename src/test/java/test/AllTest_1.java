package test;

import org.junit.Test;

/**
 * AllTest_1
 *
 * @author pysasuke
 * @date 2017/11/20
 */
public class AllTest_1 {
    @Test
    public void test() {
        //NOT DO THIS 如果字母和数字必须混合使用，字母"l"务必大写(L)，字母"O"则增加注释。
//        long i = 1l;
        long i = 1L;
        System.out.println("i 的两倍是：" + (i + i));
    }
}
