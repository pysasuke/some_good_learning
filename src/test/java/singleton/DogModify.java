package singleton;

import java.io.Serializable;

/**
 * @author pysasuke
 * @create 2017-09-06 17:38
 */
//一个实现了Serializable的单例类，必须有一个readResolve方法，用以返回它的唯一实例。
public class DogModify implements Serializable {
    public static final DogModify INSTANCE = new DogModify();
    private DogModify() {}
    private Object readResolve() {
        return INSTANCE;
    }
}
