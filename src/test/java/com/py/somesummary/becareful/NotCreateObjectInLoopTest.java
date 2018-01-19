package com.py.somesummary.becareful;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pysasuke on 2017/7/25.
 */
public class NotCreateObjectInLoopTest {
    @Test
    public void test() {
        List<User> list = getList(10);
        System.out.println("-----------------------------");
        for (User user : list) {
            System.out.println(user);
        }

        System.out.println("-----------------------------");
        List<User> list1 = getListFromAnother(list);
        for (User user : list1) {
            System.out.println(user);
        }

        System.out.println("-----------------------------");
        List<User> list2 = getListFromAnother2(list);
        for (User user : list2) {
            System.out.println(user);
        }
        System.out.println("-----------------------------");
        List<User> list3 = getListFromAnother3(list);
        for (User user : list3) {
            System.out.println(user);
        }
    }

    private List<User> getList(int count) {
        List<User> list = new ArrayList<User>(count);
        User user;
        for (int i = 0; i <= count; i++) {
            user = new User();
            user.setAge(i);
            user.setName(""+i);
            list.add(user);
        }
        return list;
    }

    private List<User> getListFromAnother(List<User> list) {
        List<User> list1 = new ArrayList<User>(list.size());

        for (User user1 : list) {
            User user = new User();
            user.setAge(user1.getAge() + 1);
            user.setName(user1.getName());
            list1.add(user);
            user = null;
        }
        return list1;
    }

    private List<User> getListFromAnother2(List<User> list) {
        List<User> list1 = new ArrayList<User>(list.size());
        User user;
        for (User user1 : list) {
            user = new User();
            user.setAge(user1.getAge() + 1);
            user.setName(user1.getName());
            list1.add(user);
        }
        return list1;
    }

    private List<User> getListFromAnother3(List<User> list) {
        List<User> list1 = new ArrayList<User>(list.size());
//        User user = new User(); //NOT DO THIS 得不到预期结果，list中对象都为同一个对象（最后一个对象）
//        for (User user1 : list) {
//            user.setAge(user1.getAge() + 1);
//            user.setName(user1.getName());
//            list1.add(user);
//        }
        return list1;
        /*
        User{age=10, name='9'}
        User{age=10, name='9'}
        User{age=10, name='9'}
        User{age=10, name='9'}
        User{age=10, name='9'}
        User{age=10, name='9'}
        User{age=10, name='9'}
        User{age=10, name='9'}
        User{age=10, name='9'}
        User{age=10, name='9'}
         */
    }
}
