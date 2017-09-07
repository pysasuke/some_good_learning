package singleton;

import java.io.Serializable;

/**
 * @author pysasuke
 * @create 2017-09-06 17:38
 */
//如果对实现了Serializable的对象进行序列化后，再反序列化，内中会不只一个实例了，因为反序列化时会重新生成一个对象
class Dog implements Serializable {
    public static final Dog INSTANCE = new Dog();
    private Dog(){}
}
