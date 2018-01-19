package com.py.somesuggest.chapter11.no141;

import lombok.Data;

/**
 *
 * @author Administrator
 * @date 2017/11/26 0026
 */
@Data
public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
