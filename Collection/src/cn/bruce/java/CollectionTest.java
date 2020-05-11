package cn.bruce.java;

import org.junit.Test;

import java.util.*;

/**
 * @author bruce
 * @project_name JavaSenior
 * @package_name cn.bruce.java
 * @create 2020-04-28 09:06
 */
public class CollectionTest {
    @Test
    public void test1() {
        Collection collection = new ArrayList();
        //1.add(Object e):将元素添加到集合中
        collection.add("ZZ");
        collection.add("AA");
        collection.add("BB");
        collection.add(123);
        collection.add(new Date());
        //2.size():获取添加元素的个数
        System.out.println(collection.size());//5
        //3.addAll(Collection coll1):将coll1集合中的元素添加到当前集合中
        Collection collection1 = new ArrayList();
        collection1.add("CC");
        collection1.add(213);
        collection.addAll(collection1);
        System.out.println(collection.size());//9
        //调用collection1中的toString()方法输出
        System.out.println(collection);//[ZZ, AA, BB, 123, Tue Apr 28 09:22:34 CST 2020, 213, 213]
        //4.clear():清空集合元素
        collection1.clear();
        System.out.println(collection1.size());//0
        System.out.println(collection1);//[]
        //5.isEmpty():判断当前集合是否为空
        System.out.println(collection1.isEmpty());//true
    }

    @Test
    public void test2() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new User("Tom", 23));
        coll.add(new User("Jarry", 34));
        coll.add(false);
        //6.contains(Object obj):判断当前集合中是否包含obj
        //判断时需要调用obj对象所在类的equals()方法
        System.out.println(coll.contains(123));//true
        System.out.println(coll.contains(new User("Tom", 23)));//true
        System.out.println(coll.contains(new User("Jarry", 23)));//false
        //7.containsAll(Collection coll1):判断形参coll1中的元素是否都存在当前集合中
        Collection coll1 = Arrays.asList(123, 4566);
        System.out.println(coll.containsAll(coll1));//flase
        //8.remove(Object obj):从当前集合中移除obj元素
        coll.remove(123);
        System.out.println(coll);//[456, Person{name='Tom', age=23}, Person{name='Jarry', age=34}, false]
        //9.removeAll(Collection coll1):差集：从当前集合中和coll1中所有的元素
        Collection coll2 = Arrays.asList(123, 456, false);
        coll.removeAll(coll2);
        System.out.println(coll);//[Person{name='Tom', age=23}, Person{name='Jarry', age=34}]
    }

    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new User("Tom", 23));
        coll.add(new User("Jarry", 34));
        coll.add(false);
        //10.retainAll(Collection coll1):交集：获取当前集合和coll1集合的交集，并返回给当前集合
        Collection coll1 = Arrays.asList(123, 345, 456);
        boolean b = coll.retainAll(coll1);
        System.out.println(b);//true
        System.out.println(coll);//[123, 456]
        //11.equals(Object obj):返回true需要当前集合和形参集合的元素相同
        Collection coll2 = new ArrayList();
        coll2.add(123);
        coll2.add(456);
        System.out.println(coll.equals(coll2));//true
        //12.hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());//5230
        //13.集合--->数组:toArray()
        Object[] array = coll.toArray();
        for (Object obj : array) {
            System.out.println(obj);
        }
        //14.数组--->集合:调用Arrays类的静态方法asList()
        List<int[]> ints = Arrays.asList(new int[]{123, 345});
        System.out.println(ints.size());//1
        List<String> strings = Arrays.asList("AA", "BB", "CC");
        System.out.println(strings);//[AA, BB, CC]
    }
}
