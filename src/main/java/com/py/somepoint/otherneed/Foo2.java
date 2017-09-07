package com.py.somepoint.otherneed;

import com.google.common.collect.ComparisonChain;

import java.util.Comparator;

/**
 * @author pysasuke
 * @create 2017-09-06 13:26
 */
public class Foo2 {

    private float score;
    private int position;
    private Person person;
    PersonComparator PERSON_COMPARATOR = new PersonComparator();

    public int compareTo(Foo other) {
        return ComparisonChain.start()
                .compare(score, other.getScore())
                .compare(position, other.getPosition())
                .compare(person, other.getPerson(), PERSON_COMPARATOR).result();
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

    private static class PersonComparator implements Comparator<Person> {
        @Override
        public int compare(Person a, Person b) {
            return a.toString().compareTo(b.toString());
        }

    }
}
