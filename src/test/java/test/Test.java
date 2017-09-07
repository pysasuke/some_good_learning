package test;

import java.util.Random;

/**
 * java Test 1 2 a
 * @author pysasuke
 * @create 2017-09-06 14:26
 */
public class Test {
    public static void main(String[] args){
        for(int i = 0; i < args.length; i++){
            System.out.println(args[i]);//1 2 a
        }
    }
    @org.junit.Test
    public void test(){
        Random rnd = new Random();
        System.out.println(rnd.nextInt(2));//0 或者 1
    }
}
