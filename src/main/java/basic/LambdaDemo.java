package basic;

import java.util.Arrays;
import java.util.Comparator;

/*
 * jdk8 new feature
 * 当接口中只有一个abstract方法时
 * 形式：(抽象方法中参数) -> {抽象方法中的方法体}
 * 相当于创建了一个（实现此）接口（的类）的对象，e.g. obj3
 * */
public class LambdaDemo {
    public static void main(String[] args) {
        //1st way
        Interface obj1 = new IClass();
        obj1.method();

        //2nd way
        Interface obj2 = new Interface() {
            @Override
            public void method() {
                System.out.println("anonymous inner class way");
            }
        };
        obj2.method();

        //3th way: Lambda
        //when the method has only one raw, "{}" can be omitted, otherwise, {} should be there
        Interface obj3 = () -> {
            System.out.println("lambda with no parameters");
        };

        Interface1 obj4 = (name, age) -> {
            System.out.println("lambda with parameters");
            System.out.println("name is " + name + ", age is " + age);
        };
        obj4.method("ladycui", 18);

        Interface2 obj5 = (name, age) -> {
            System.out.println("lambda with return value");
            return age;
        };
        obj5.method("ladycui", 18);


        //an example: compare two objects
        Person[] persons = {
                new Person("one", 15),
                new Person("two", 11),
                new Person("three", 13)
        };

        //原来的方法
        Arrays.sort(persons, new Comparator<Person>() {
            public int compare(Person p1, Person p2) {
                return p1.age - p2.age;
            }
        });
//        System.out.println(Arrays.toString(persons));

        //lambda way
        //when there is only "return" row in the method, "return" can be omitted
        Arrays.sort(persons, (p1, p2) -> p1.age - p2.age);
        System.out.println(Arrays.toString(persons));


    }
}


interface Interface {
    void method();
}

//jdk1.8中可以添加default方法和static方法，方便后面添加方法；1.8前不可以
interface Interface1 {
    void method(String name, int age);

    default void method2() {
        System.out.println("default method doesn't influnce");
    }

    static void method3() {
        System.out.println("static method doesn't matter ether");
    }
}

interface Interface2 {
    int method(String name, int age);
}

class IClass implements Interface {
    public void method() {
        System.out.println("class implementation way");
    }
}

