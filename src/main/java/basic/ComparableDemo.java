package basic;

import java.util.Arrays;
import java.util.Comparator;

public class ComparableDemo {
    public static void main(String[] args) {
        Cat cat1 = new Cat("cat1", 1);
        Cat cat2 = new Cat("cat2", 5);
        Cat cat3 = new Cat("cat3", 3);
        Cat[] cats = {cat1, cat2, cat3};
        Arrays.sort(cats);
        System.out.println(Arrays.toString(cats));

        Dog4Compare dog1 = new Dog4Compare("dog1", 2);
        Dog4Compare dog2 = new Dog4Compare("dog2", 6);
        Dog4Compare dog3 = new Dog4Compare("dog3", 4);
        Dog4Compare[] dogs = {dog1, dog2, dog3};
        Arrays.sort(dogs, new DogComparator());
        System.out.println(Arrays.toString(dogs));
    }
}

class Dog4Compare {
    String name;
    int age;

    public Dog4Compare(String name, int age) {
        this.name = name;
        this.age = age;
    }

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

    @Override
    public String toString() {
        return "Dog4Compare{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class DogComparator implements Comparator<Dog4Compare> {

    @Override
    public int compare(Dog4Compare o1, Dog4Compare o2) {
        if (o1.age < o2.age)
            return -1;
        else if (o1.age > o2.age)
            return 1;
        return 0;
    }
}

class Cat implements Comparable<Cat> {
    String name;
    int age;

    @Override
    public int compareTo(Cat c) {
        if (this.age < c.age)
            return -1;
        else if (this.age > c.age)
            return 1;
        return 0;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

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

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}