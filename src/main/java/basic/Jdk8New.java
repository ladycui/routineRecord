package basic;
/*
 * jdk1.8新特性：lambda/
 * Function<T,R>/ apply(T t)
 * Supplier<T>/ T get()
 * Predicate<T>/ boolean test(T t)
 * Stream<T> //函数式编程
 *   Iterator只能一个一个的遍历元素then操作
 *   两种操作方法：中间操作（中间生成Stream）和结束操作（执行计算操作）
 *
 *   ::方法引用
 *       引用静态方法  Integer::valueOf
 *       应用对象的方法 list::add
 *       引用构造方法  ArrayList::new
 *
 * */

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Jdk8New {

    public static void main(String[] args) {

        Jdk8New obj = new Jdk8New();
        obj.functionMethod();
//        Supplier
//        Predicate

        Stream<String> stream = Stream.of("one", "two", "three", "four", "one", "two");

        //forEach(Consumer<T> action)
//        stream.forEach((str) -> {System.out.println(str);});
//        stream.forEach(System.out::println);//同上

        //filter返回Stream，属于中间操作，需要再用forEach遍历
//        stream.filter((s) -> s.length() > 3).forEach(System.out::println);

//        stream.distinct().forEach(s -> System.out.println(s));

//        stream.map(Function<T, R> function)
//        stream.map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

        //flatMap(Function<T, R>) 合并为一个Stream<T>
        //可以再参考java代码中flatmap的examples
        Stream<List<Integer>> stream2 = Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(4, 5));
        stream2.flatMap(list -> list.stream()).forEach(System.out::println);

//        Optional<String> opt = stream.reduce((s1, s2) -> s1.length() >= s2.length() ? s1 : s2);
//        System.out.println(opt.get());

        //stream 转换为 Collection
        List<String> list = stream.collect(Collectors.toList());
        list.forEach(System.out::println);

    }

    //Function<T, R> //R means result 返回类型
    public String upString(String s, Function<String, String> f) {   //随便写一个含有Function参数的方法
        return f.apply(s);
    }

    public void functionMethod() {
        String string = upString("abc", s -> s.toUpperCase());
        System.out.println(string);
    }

}
