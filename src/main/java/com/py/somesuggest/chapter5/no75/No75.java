package com.py.somesuggest.chapter5.no75;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 集合中的元素必须做到compareTo和equals同步
 *
 * @author Administrator
 * @date 2017/10/29 0029
 * 注意：实现了compareTo方法，就应该覆写equals方法，确保两者同步。
 */
/*
indexOf是通过equals方法判断的，equals等于true就认为找到符合条件的元素了，
而binarySearch查找的依据是compareTo方法的返回值，返回0即认为找到符合条件的元素。

理解两点：
    indexOf依赖equals方法查找，binarySearch则依赖compareTo方法查找
    equals是判断元素是否相等，compareTo时判断元素在排序中的位置是否相同
 */
public class No75 {
    public static void main(String[] args) {
        List<City> cities = new ArrayList<>();
        cities.add(new City("021", "上海"));
        cities.add(new City("021", "沪"));
        //排序
        Collections.sort(cities);
        //查找对象
        City city = new City("021", "沪");
        //indexOf方法取得索引值
        int index1 = cities.indexOf(city);
        //binarySearch查找到索引值
        int index2 = Collections.binarySearch(cities, city);
        //索引值(indexOf):0
        System.out.println("索引值(indexOf):" + index1);
        //索引值(binarySearch):1
        System.out.println("索引值(binarySearch):" + index2);
    }
}

class City implements Comparable<City> {
    /**
     * 城市编码
     */
    private String code;
    /**
     * 城市名称
     */
    private String name;

    public City(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(City o) {
        //按城市名称排序
        return new CompareToBuilder()
                .append(name, o.name)
                .toComparison();

    }

    @Override
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
        City city = (City) obj;
        //根据code判断是否相等
        return new EqualsBuilder()
                //NOT DO THIS    集合中的元素必须做到compareTo和equals同步
//                .append(code, city.code)
                .append(name, city.name)
                .isEquals();
    }
}