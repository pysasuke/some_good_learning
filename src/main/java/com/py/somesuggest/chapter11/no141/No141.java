package com.py.somesuggest.chapter11.no141;


import org.apache.commons.beanutils.*;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.apache.commons.collections.Bag;
import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.Factory;
import org.apache.commons.collections.bag.HashBag;
import org.apache.commons.collections.bidimap.TreeBidiMap;
import org.apache.commons.collections.list.LazyList;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.mutable.MutableInt;
import org.apache.commons.lang3.text.WordUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Apache扩展包
 * Created by Administrator on 2017/11/26 0026.
 */
public class No141 {
    public static void main(String[] args) {
    }

    //(1)Lang
    @Test
    public void langTest() {
        //1.字符串操作工具类
        StringTest();
        //2.Object工具类(见Person类)
        //3.可变的基本类型
        mutableBaseTest();
        //4.其他Utils工具

    }

    //BeanUtils
    @Test
    public void beanUtilsTest() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        //1.属性拷贝
        attrCopyTest();
        //2.动态Bean和自由bean
        dynaBeanTest();
        //3.转换器
        converTest();
    }

    //(3)Collections
    @Test
    public void collectionsTest() {
        //1.Bag
        bagTest();
        //lazy
        lazyTest();
        //双向Map
        bidiMapTest();
    }

    private void StringTest() {
        String str = "123";
        //判断一个字符串是否为空，null或""都返回true
        System.out.println(StringUtils.isEmpty(str));    //false
        //是否数字
        System.out.println(StringUtils.isNumeric(str));    //true
        //最左边两个字符
        System.out.println(StringUtils.left(str, 2));    //12
        //统计子字符串出现的次数
        System.out.println(StringUtils.countMatches(str, "1"));    //1
        //转译XML标识
        System.out.println(StringEscapeUtils.escapeXml(str));    //123
        //随机生成，长度为10的仅字母的字符串
        System.out.println(RandomStringUtils.randomAlphabetic(10));    //bMbuUQoasP
        //随机生成，长度为10的ASCII字符串
        System.out.println(RandomStringUtils.randomAscii(10));    //]uanJ ^9Mu
        //以一个单词为操作对象，首字母大写，输出结果为Abc Bcd
        System.out.println(WordUtils.capitalize("abc bcd"));    //Abc Bcd
    }

    public void mutableBaseTest() {
        //声明一个可变的int类型
        MutableInt mi = new MutableInt(10);
        //mi加10，结果为20
        mi.add(10);
        System.out.println(mi);    //20
        //自加1，结果为21
        mi.increment();
        System.out.println(mi);    //21
    }

    private void attrCopyTest() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //PO对象
        User user = new User("张三", 10);
        //VO对象
        UserVO userVO = new UserVO();
        //两个Bean属性拷贝(自己总结：User和UserVO必须是public class，否则不起作用)
        PropertyUtils.copyProperties(userVO, user);    //UserVO(name=张三, age=10)
        System.out.println(userVO);
        //把Map中的键值对拷贝到Bean上
        Map<String, String> map = new HashMap<>();
        map.put("name", "李四");
        PropertyUtils.copyProperties(userVO, map);
        System.out.println(userVO);    //UserVO(name=李四, age=10)
    }

    private void dynaBeanTest() throws InstantiationException, IllegalAccessException {
        DynaProperty[] props = new DynaProperty[]{
                new DynaProperty("name", String.class),
                new DynaProperty("age", int.class)
        };
        BasicDynaClass dynaClass = new BasicDynaClass("people", null, props);
        //动态Bean对象
        DynaBean people = dynaClass.newInstance();
        /*people的get/set操作*/
        people.set("name", "张三");
        //自由Bean
        DynaBean user = new LazyDynaBean();
        //直接定义属性和值
        user.set("name", "张三");
        //定义属性名，限定属性类型为Map
        user.set("phoneNum", "tel", "021");
        user.set("phoneNum", "mobile", "138");
        //属性类型为ArrayList
        user.set("address", 0, "上海");
        user.set("address", 1, "北京");
    }

    private void converTest() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //一个简单的Bean对象
        User user = new User("张三", 18);
        //转换工具
        ConvertUtilsBean cub = new ConvertUtilsBean();
        //注册一个转换器
        cub.register(new Converter() {
            @Override
            public Object convert(Class type, Object value) {
                //为每个String类型的属性加上前缀
                return "prefix-" + value;
            }
        }, String.class);
        //建立一个依赖特定转换工具的Bean工具类
        BeanUtilsBean beanUtils = new BeanUtilsBean(cub);
        //输出结果为：prefix-张三
        System.out.println(beanUtils.getProperty(user, "name"));    //prefix-张三
    }

    private void bagTest() {
        //一个盒子中装了4个球
        Bag box = new HashBag(Arrays.asList("red", "blue", "black", "blue"));
        //又增加3个蓝色球
        box.add("blue", 3);
        //球的数量为7
        System.out.println(box.size());    //7
        //蓝色球数量为5
        System.out.println(box.getCount("blue"));    //5
    }

    private void lazyTest(){
        //把一个List包装成一个lazy类型
        List<String> lazy = LazyList.decorate(new ArrayList(),
                new Factory() {
                    @Override
                    public Object create() {
                        return "A";
                    }
                });
        //访问了第4个元素，此时0、1、2元素为null
        String obj =lazy.get(3);    //A
        System.out.println(obj);
        //追加一个元素
        lazy.add("第五个元素");
        System.out.println(lazy.size());     //5
    }

    private void bidiMapTest(){
        //key、value都不允许重复的Map
        BidiMap bidiMap = new TreeBidiMap();
        bidiMap.put(1,"壹");
        //根据key获取value
        System.out.println(bidiMap.get(1));    //壹
        //根据value获取key
        System.out.println(bidiMap.getKey("壹"));    //1
        //根据value删除键值对
        bidiMap.removeValue("壹");
        System.out.println(bidiMap.get(1));    //null
    }
}

class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //自定义输出格式
    public String toString() {
        return new ToStringBuilder(this)
                .append("姓名", name)
                .append("年龄", age)
                .toString();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Person p = (Person) obj;
        //只要姓名相同，就认为两个对象相等
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(name, p.name)
                .isEquals();
    }

    //自定义hashCode
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}



