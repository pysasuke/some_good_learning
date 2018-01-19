package com.py.somesuggest.chapter3.no47;

/**
 * 在equals中使用getClass进行类型判断
 *
 * @author Administrator
 * @date 2017/10/17 0017
 */
//在覆写equals时建议使用getClass进行类型判断，而不要使用instanceof
public class No47 {
    public static void main(String[] args) {
        Employee e1 = new Employee("张三 ", 100);
        Employee e2 = new Employee("张三 ", 1001);
        Person p1 = new Person("张三 ");
        //true
        System.out.println(p1.equals(e1));
        //true
        System.out.println(p1.equals(e2));
        //false
        System.out.println(e1.equals(p1));
        //false
        System.out.println(e1.equals(e2));
    }
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        //NOT DO THIS  违反了equals的传递性原则：对于实例对象x、y、z来说，如果x.equals(y)返回true，y.equals(z)返回true，那么x.equals(z)也应该返回true。
//        if (obj instanceof Person) {
        if (null != obj && obj.getClass() == this.getClass()) {
            Person p = (Person) obj;
            if (p.getName() == null || name == null) {
                return false;
            } else {
                return name.equalsIgnoreCase(p.getName());
            }
        }
        return false;
    }
}

class Employee extends Person {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee(String name, int id) {
        super(name);
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
//        if (obj instanceof Employee) {
        if (null != obj && obj.getClass() == this.getClass()) {
            Employee e = (Employee) obj;
            return super.equals(obj) && e.getId() == id;
        }
        return false;
    }

}
