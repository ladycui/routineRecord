package basic;

import java.util.Collection;
import java.util.Iterator;

/*
 * 常用的迭代方法：foreach/Iterator等
 * */
public class IteratorDemo {

    public static void main(String[] args) {
    }

    public void foreachIteration(Collection<Person> persons) {
        for (Person p : persons) {
            //...
        }
    }

    public void iteratorIteration(Collection<Person> persons) {
        Iterator<Person> iterator = persons.iterator();
        while (iterator.hasNext()) {
            //iterator.next();
        }
    }
}
