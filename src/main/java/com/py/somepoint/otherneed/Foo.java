package com.py.somepoint.otherneed;

import com.google.common.collect.ComparisonChain;

/**
 * @author pysasuke
 * @create 2017-09-06 13:26
 */
public class Foo {

    private float score;
    private int position;
    private Person person;
    //但是上面这种实现方式总是会先生成两个 String 对象来保存 bar.toString() 和other.getBar().toString() 的值，即使这两个字符串的比较可能不需要。避免这样的开销，可以为Bar 对象实现一个 comparator：如Foo2类
    public int compareTo(Foo other) {
        return ComparisonChain.start()
                .compare(score, other.getScore())
                .compare(position, other.getPosition())
                .compare(person.toString(), other.getPerson().toString()).result();
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
