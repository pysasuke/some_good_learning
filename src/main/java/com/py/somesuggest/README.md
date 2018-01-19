##三元操作符类型的转换规则：
(1)若两个操作数不可转换，则不做转换，返回值为Object类型。
(2)若两个操作数是明确类型的表达式(比如变量)，则按照正常的二进制数字来转换，int类型转换为long类型，long类型转换为float类型等。
(3)若两个操作数中有一个数字S，另外一个是表达式，且其类型标示为T，那么，若数字S在T的范围内，则转换为T类型；若S超出T类型的范围，则T转换为S类型。
(4)若两个操作数都是直接量数字，则返回值类型为范围较大者。

示例代码：
```
    @Test
    public void test() {
        int i = 80;
        String s1 = String.valueOf(i < 100 ? 90 : 100);
        String s2 = String.valueOf(i < 100 ? 90 : 100.0);
        System.out.println("s1=" + s1);
        System.out.println("s2=" + s2);
    }
```
结果：
```
s1=90
s2=90.0
```
结论：三元操作符的类型务必一致
##clone方法拷贝规则
clone方法提供的是一种浅拷贝方式，也就是说它并不会把对象的所有属性全部拷贝一份，而是选择性的拷贝，它的拷贝规则如下：
(1)基本变量：如果变量是基本类型，则拷贝其值，比如int、float等
(2)对象：如果变量是一个实例对象，则拷贝地址引用，也就是说此时新拷贝出来的对象与原有对象共享改实例变量，不受访问权限的控制。
(3)String字符串：这个比较特殊，拷贝的也是一个地址，是个引用，但是在修改时，它会从字符串池中重新生成新的字符串，原有的字符串对象保持不变，在此处我们可以认为String是一个基本类型

示例代码：
```
    @Test
    public void test() {
        //定义父亲
        Person father = new Person("父亲");
        //定义大儿子
        Person s1 = new Person("大儿子", father);
        //小儿子的信息是通过大儿子拷贝过来的
        Person s2 = s1.clone();
        s2.setName("小儿子");
        System.out.println(s1.getName() + " 的父亲是 " + s1.getFather().getName());
        System.out.println(s2.getName() + " 的父亲是 " + s2.getFather().getName());
        s1.getFather().setName("干爹");
        System.out.println(s1.getName() + " 的父亲是 " + s1.getFather().getName());
        System.out.println(s2.getName() + " 的父亲是 " + s2.getFather().getName());
    }
```
辅助类：
```
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
```
结果：
```
大儿子 的父亲是 父亲
小儿子 的父亲是 父亲
大儿子 的父亲是 干爹
小儿子 的父亲是 干爹
```
结论：浅拷贝只是Java提供的一种简单拷贝机制，不便于直接使用
## 字符串池：
创建一个字符串时，首先检查池中是否有字面值相等的字符串，如果有，则不再创建，直接返回池中该对象的引用，若没有则创建之，然后放到池里，并返回新创建对象的引用。

示例代码：
```
    @Test
    public void test(){
        String str1 = "中国";
        String str2 = "中国";
        String str3 = new String("中国");
        String str4 = str3.intern();
        //两个直接量是否相等
        boolean b1 = (str1 == str2);
        //直接量和对象是否相等
        //直接声明一个String对象(new String)是不会检查字符串池的，也不会把对象放到池里
        boolean b2 = (str1 == str3);
        //经过intern处理后的对象与直接量是否相等
        //intern会检查当前的对象在对象池(自己理解：字符串池)中是否有字面值相同的引用对象，如果有则返回池中对象，如果没有则放置到对象池中，并返回当前对象
        boolean b3 = (str1 == str4);
        System.out.println(b1);    
        System.out.println(b2);    
        System.out.println(b3);    
    }
```
结果：
```
true
false
true
```
结论：推荐使用String直接量赋值
## String类是一个不可变对象：
(1)String类是final类，不可继承，不可能产生一个String子类
(2)在String类提供的所有方法中，如果有String返回值，就会新建一个String对象，不对原对象进行修改，这也保证了元对象是不可改变的。
## String、StringBuffer、StringBuilder三者使用场景：
(1)使用String类的场景：在字符串不经常变化的场景中可以使用String类，例如常量的声明、少量的变量运算等。
(2)使用StringBuffer类的场景：在频繁进行字符串的运算(如拼接、替换、删除等)，并且运行在多线程的环境中，则可以考虑使用StringBuffer，例如XML解析、HTTP参数解析和封装等。
(3)使用StringBuilder类的场景：在频繁进行字符串的运算(如拼接、替换、删除等)，并且运行在单线程的环境中，则可以考虑使用StringBuilder，如SQL语句的拼装、JSON封装等。
## Java对加号的处理机制：
在使用加号进行计算的表达式中，只要遇到String字符串，则所有的数据都会转成String类型进行拼接，如果是原始数据，则直接拼接，如果是对象，则调用toString方法的返回值然后拼接

示例代码：
```
    @Test
    public void test(){
        String str1 = 1 + 2 + " apples";
        String str2 = "apples:" + 1 + 2;
        System.out.println(str1);    
        System.out.println(str2);    
    }
```
结果：
```
3 apples
apples:12
```
结论：在"+"表达式中，String字符串具有最高优先级
## ArrayList与LinkedList
ArrayList：
    插入：只要插入一个元素，其后的元素就会向后移动一位，虽然arrayCopy是一个本地方法，效率非常高，
        但频繁的插入，每次后面的元素都要拷贝一遍，效率就变低了，特别是在头位置插入元素时。
    删除：index位置后的元素都要向前移动一位，最后一个位置空出来了，这又是一次数组拷贝，和插入一样，
        如果数据量大，删除动作必然会暴露出性能和效率方面的问题。
    修改：直接替换
LinkedList：
    插入：把自己插入到链表，然后再把前节点的next和后节点的previous指向自己。
    删除：没有任何耗时的操作，全部是引用指针的变更，效率自然高了。
    修改：定位方式会折半遍历，这是一个极耗时的操作。

总结：
    LinkedList的插入效率比ArrayList快50倍以上。
    LinkedList在处理大批量的删除动作时比ArrayList快40倍以上。
    修改元素，在这一点上LinkedList输给了ArrayList
结论：频繁插入和删除时使用LinkedList
##subList方法实现原理
它返回的SubList类也是AbstractList的子类，其所以的方法如get、set、add、remove等都是在原始列表上的操作，它自身并没有生成一个数组或是链表，也就是子列表只是原列表的一个视图，所有的修改动作都反映在了原始列表上。

示例代码：
```
    @Test
    public void test(){
        //定义一个包含两个字符串的列表
        List<String> list = new ArrayList<>(2);
        list.add("A");
        list.add("B");
        //构造一个包含list列表的字符串列表
        List<String> list2 = new ArrayList<>(list);
        System.out.println("list == list2? " + list.equals(list2));    
        //subList生成与list相同的列表
        List<String> list3 = list.subList(0, list.size());
        //list3增加一个元素
        list3.add("C");
        System.out.println("list == list2? " + list.equals(list2));    
        System.out.println("list == list3? " + list.equals(list3));    
        System.out.println(list.size());    
    }
```
结果：
```
list == list2? true
list == list2? false
list == list3? true
3
```
结论：subList产生的列表只是一个视图，所有的修改动作直接作用于原列表
##编译后泛型类型转换规则
(1)List<String>、List<Integer>、List<T>擦除后的类型为List。
(2)List<String>[] 擦除后的类型为List[].
(3)List<? extends E>、List<? super E>擦除后的类型为List<E>。
(4)List<T extends Serializable & Cloneable>擦除后为List<Serializable>。
## Class类的特殊性
(1)无构造函数：Class对象是在加载类时由Java虚拟机通过调用类加载器中的defineClass方法自动构造的。
(2)可以描述基本类型：例如可以使用int.class表示int表示类型的类对象
(3)其对象都是单例模式：一个Class的实例可以描述一个类，并且只描述一个类，反过来也成立，一个类只有一个Class实例对象

示例代码：
```
    @Test
    public void test() {
        //类的属性class所引用的对象与实例对象的getClass返回值相同
        System.out.println(String.class.equals(new String("").getClass()));
        System.out.println("ABC".getClass().equals(String.class));
        //class实例对象不区分泛型
        System.out.println(ArrayList.class.equals(new ArrayList<String>().getClass()));
    }
```
结果：
```
true
true
true
```
## 获得一个Class对象的三种路径
(1)类属性方式，如String.class
(2)对象的getClass方法，如new String().getClass()
(3)forName方法加载，如Class.forName("java.lang.String")
## getMethod和getDeclareMethod
getMethod方法获得的是所以public访问级别的方法，包括从父类继承的方法
getDeclareMethod方法获得的是自身类的所有方法，包括public、private方法，而且不受限于访问权限

示例代码：
```
    @Test
    public void test() throws NoSuchMethodException {
        //方法名称
        String methodName = "doStuff";
        Method m1 = Foo.class.getDeclaredMethod(methodName);
        Method m2 = Foo.class.getMethod(methodName);    //Exception in thread "main" java.lang.NoSuchMethodException
    }
    //静态内部类
    static class Foo{
        void doStuff(){}
    }
```
结果：
```
java.lang.NoSuchMethodException
```
结论：适时选择getDeclaredXXX和getXXX