package com.py.somesuggest.chapter3.no40;


/**
 * 匿名类的构造函数很特殊
 *
 * @author Administrator
 * @date 2017/10/11 0011
 */
/*
匿名类的构造函数特殊处理机制，一般类(也就是具有显式名字的类)的所
有构造函数默认都是调用父类的无参构造，而匿名类因为没有名字，只能由构造代码块代替，
也就无所谓的有参和无参构造函数了，它在初始化时直接调用了分类的同参数构造，
然后再调用了自己的构造代码块
 */
public class No40 {
    enum Ops {ADD, SUB}

    class Calulator {
        private int i, j, result;

        /**
         * 无参构造
         */
        public Calulator() {
        }

        /**
         * 有参构造
         * @param i
         * @param j
         */
        public Calulator(int i, int j) {
            this.i = i;
            this.j = j;
        }

        /**
         * 设置符号，是加法运算还是减法运算
         * @param op
         */
        protected void setOperator(Ops op) {
            result = op.equals(Ops.ADD) ? i + j : i - j;
        }

        /**
         * 取得运算结果
         * @return
         */
        public int getResult() {
            return result;
        }
    }

    class Add extends Calulator {
        {
            setOperator(Ops.ADD);
        }

        /**
         * 覆写父类构造方法
         * @param i
         * @param j
         */
        public Add(int i, int j) {

        }
    }

    class Add2 extends Calulator {
        {
            setOperator(Ops.ADD);
        }

        /**
         * 覆写父类构造方法
         * @param i
         * @param j
         */
        public Add2(int i, int j) {
            super(i, j);
        }
    }

    public static void main(String[] args) {
        No40 no40 = new No40();
        //与下面c3代码等价
        No40.Calulator c1 = no40.new Calulator(1, 2) {
            {
                setOperator(Ops.ADD);
            }
        };
        //3
        System.out.println(c1.getResult());

        No40.Calulator c2 = no40.new Add(1, 2) {
            {
                setOperator(Ops.ADD);
            }
        };
        //0
        System.out.println(c2.getResult());
        /*
        首先会调用分类有两个参数的构造函数，而不是无参构造
         */
        No40.Calulator c3 = no40.new Add2(1, 2) {
            {
                setOperator(Ops.ADD);
            }
        };
        //3
        System.out.println(c3.getResult());
    }
}
