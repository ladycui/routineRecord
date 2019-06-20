package basic;


/*
 * Collection--List, Set //these are all interfaces
 *       List---ArrayList, Vector, LinkedList    //Vector线程安全的，ArrayList not; LinkedList双向链表
 *       Set---HashSet, TreeSet  //分别基于HashMap和TreeMap   //TreeSet对象比较大小，通过Comparator或Comparable实现，详细去参照CompareDemo.java文件
 *                               //HashSet 有两个影响其性能的参数：初始容量 和 加载因子
 *             HashSet--LinkedHashSet    //LindedHashSet迭代顺序按照元素插入的顺序；注意，插入顺序不受在 set 中重新插入的元素的影响，即如果在 s.contains(e) 返回 true 后立即调用 s.add(e)，则元素 e 会被重新插入到 set s 中。）
 *       Map--HashMap, HashTable, TreeMap
 *               HashMap线程不安全，初始默认大小16,扩充×2, 1.8前使用数组+链表形式，1.8使用数组+链表+红黑树（当链表元素> 8时）
 *                   LinkedHashMap,hashmap子类，HashMap不能保证元素顺序恒久不变，LinkedHashMap使用双向链表保存数据
 *              HashTable线程安全的，默认初始大小11, 扩充：×2+1,
 *               TreeMap
 *比较两个对象内容是否“==”，重写hashCode()和equals()，步骤是：先比较两个对象的hashCode值，若不相等则两个对象不等；若hashCode值相等，再使用equals()判断。
 *哈希表的存储结构是数组+链表，hashCode相等的元素以链表形式存储
 *
 * 排序-> TreeSet；
 * 不排序，也不保证顺序-> HashSet
 * 不排序，保证顺序->LinkedHashSet
 *
 * Consumer<T>/ accept(T t)
 *
 * */

import java.util.*;

public class CollectionDemo {

    public static void main(String[] args) {
        TreeSet<Person> treePerson = new TreeSet<>(new Comparator<Person>() {   //没有Comparator的话，后面size()报错
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        Person p1 = new Person("one", 10);
        Person p2 = new Person("two", 10);
        treePerson.add(p1);
        treePerson.add(p2);
        System.out.println(treePerson.size());  //1, tree中只有p1, p2没存进去
        for (Person p : treePerson)
            System.out.println(p);

        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        //Consumer lambda表达式
//        list.forEach((p) -> {System.out.println(p);});
        list.forEach(p -> System.out.println(p));
        list.forEach(System.out::println);//::


        /*HashMap*/
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("one", "11111");
        hashMap.put("two", "22222");

        hashMap.get("one");//get(K)

        //iteration
        Set<Map.Entry<String, String>> entrySet = hashMap.entrySet();
        for (Map.Entry e : entrySet) {
            System.out.println(e.getKey() + "---" + e.getValue());
        }

        //another iteration
        Set<String> keys = hashMap.keySet();
        for (String key : keys) {
            String value = hashMap.get(key);
            System.out.println(key + "--" + value);
        }

        //another iteration
        Collection<String> values = hashMap.values();

        //another iteration
        hashMap.forEach((key, value) -> System.out.println(key + "--" + value));

    }
}
