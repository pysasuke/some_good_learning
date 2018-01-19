package com.py.somesuggest.chapter3.no41;

/**
 * 让多重继承成为现实
 *
 * @author Administrator
 * @date 2017/10/14 0014
 */
public class No41 {
}

interface Father {
    int strong();
}

interface Mother {
    int kind();
}

class FatherImpl implements Father {
    //父亲的强壮指数是8
    @Override
    public int strong() {
        return 8;
    }
}

class MotherImpl implements Mother {
    //母亲的温柔指数是8
    @Override
    public int kind() {
        return 8;
    }
}

class Son extends FatherImpl implements Mother {
    @Override
    public int strong() {
        //儿子比父亲强壮
        return super.strong() + 1;
    }

    @Override
    public int kind() {
        return new MotherSpecial().kind();
    }

    /**
     * 成员内部类(实例内部类)
     */
    private class MotherSpecial extends MotherImpl {
        @Override
        public int kind() {
            //儿子温柔指数降低了
            return super.kind() - 1;
        }
    }
}

class Daugther extends MotherImpl implements Father {

    @Override
    public int strong() {
        return new FatherImpl() {
            @Override
            public int strong() {
                //女儿的强壮指数降低了
                return super.strong() - 2;
            }
        }.strong();
    }
}