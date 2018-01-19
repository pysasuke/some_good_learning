package test;

import com.py.somesuggest.chapter7.no102.No102;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * AllTest
 *
 * @author pysasuke
 * @date 2017/11/20
 */
public class AllTest {
    //    @Test
//    public void test() {
//        int i = 80;
//        String s1 = String.valueOf(i < 100 ? 90 : 100);
//        String s2 = String.valueOf(i < 100 ? 90 : 100.0);
//        System.out.println("s1=" + s1);
//        System.out.println("s2=" + s2);
//    }
//    @Test
//    public void test() {
//        //定义父亲
//        Person father = new Person("父亲");
//        //定义大儿子
//        Person s1 = new Person("大儿子", father);
//        //小儿子的信息是通过大儿子拷贝过来的
//        Person s2 = s1.clone();
//        s2.setName("小儿子");
//        System.out.println(s1.getName() + " 的父亲是 " + s1.getFather().getName());
//        System.out.println(s2.getName() + " 的父亲是 " + s2.getFather().getName());
//        s1.getFather().setName("干爹");
//        System.out.println(s1.getName() + " 的父亲是 " + s1.getFather().getName());
//        System.out.println(s2.getName() + " 的父亲是 " + s2.getFather().getName());
//    }
//    @Test
//    public void test(){
//        String str1 = "中国";
//        String str2 = "中国";
//        String str3 = new String("中国");
//        String str4 = str3.intern();
//        //两个直接量是否相等
//        boolean b1 = (str1 == str2);
//        //直接量和对象是否相等
//        //直接声明一个String对象(new String)是不会检查字符串池的，也不会把对象放到池里
//        boolean b2 = (str1 == str3);
//        //经过intern处理后的对象与直接量是否相等
//        //intern会检查当前的对象在对象池(自己理解：字符串池)中是否有字面值相同的引用对象，如果有则返回池中对象，如果没有则放置到对象池中，并返回当前对象
//        boolean b3 = (str1 == str4);
//        System.out.println(b1);
//        System.out.println(b2);
//        System.out.println(b3);
//    }
//    @Test
//    public void test(){
//        String str1 = 1 + 2 + " apples";
//        String str2 = "apples:" + 1 + 2;
//        System.out.println(str1);
//        System.out.println(str2);
//    }
//    @Test
//    public void test(){
//        //定义一个包含两个字符串的列表
//        List<String> list = new ArrayList<>(2);
//        list.add("A");
//        list.add("B");
//        //构造一个包含list列表的字符串列表
//        List<String> list2 = new ArrayList<>(list);
//        System.out.println("list == list2? " + list.equals(list2));
//        //subList生成与list相同的列表
//        List<String> list3 = list.subList(0, list.size());
//        //list3增加一个元素
//        list3.add("C");
//        System.out.println("list == list2? " + list.equals(list2));
//        System.out.println("list == list3? " + list.equals(list3));
//        System.out.println(list.size());    //3
//    }
//    @Test
//    public void test() {
//        //类的属性class所引用的对象与实例对象的getClass返回值相同
//        System.out.println(String.class.equals(new String("").getClass()));
//        System.out.println("ABC".getClass().equals(String.class));
//        //class实例对象不区分泛型
//        System.out.println(ArrayList.class.equals(new ArrayList<String>().getClass()));
//    }
//    @Test
//    public void test() throws NoSuchMethodException {
//        //方法名称
//        String methodName = "doStuff";
//        Method m1 = Foo.class.getDeclaredMethod(methodName);
//        Method m2 = Foo.class.getMethod(methodName);    //Exception in thread "main" java.lang.NoSuchMethodException
//    }
    //静态内部类
//    static class Foo{
//        void doStuff(){}
//    }
}

class Person implements Cloneable {
    //姓名
    private String name;
    //父亲
    private Person father;

    public Person(String _name) {
        name = _name;
    }

    public Person(String _name, Person _parent) {
        name = _name;
        father = _parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    //拷贝的实现
    @Override
    public Person clone() {
        Person p = null;
        try {
            //浅拷贝
            p = (Person) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}