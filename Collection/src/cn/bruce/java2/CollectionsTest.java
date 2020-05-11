package cn.bruce.java2;

/**
 * @author bruce
 * @project_name JavaSenior
 * @package_name cn.bruce.java2
 * @create 2020-04-29 15:57
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * reverse(List)：反转 List 中元素的顺序
 * shuffle(List)：对 List 集合元素进行随机排序
 * sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
 * sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
 * swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
 * <p>
 * Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
 * Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
 * Object min(Collection)
 * Object min(Collection，Comparator)
 * int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
 * void copy(List dest,List src)：将src中的内容复制到dest中
 * boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换 List 对象的所有旧值
 */

public class CollectionsTest {
    /**
     * Collections 类中提供了多个 synchronizedXxx() 方法，
     * 该方法可使将指定集合包装成线程同步的集合，从而可以解决
     * 多线程并发访问集合时的线程安全问题
     */
    @Test
    public void test3() {

        List list = new ArrayList();
        list.add(123);
        list.add(123);
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(0);
        System.out.println(list);//[123, 43, 765, -97, 0]
        //返回的list1即为线程安全的List
        List list1 = Collections.synchronizedList(list);
        System.out.println(list1);//[123, 123, 123, 43, 765, -97, 0]
    }


    /**
     * Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
     * Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
     * Object min(Collection)
     * Object min(Collection，Comparator)
     * int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
     * void copy(List dest,List src)：将src中的内容复制到dest中
     * boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换 List 对象的所有旧值
     */
    @Test
    public void test2() {
        List list = new ArrayList();
        list.add(123);
        list.add(123);
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(0);
        System.out.println(list);//[123, 43, 765, -97, 0]
        //Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
        Comparable max = Collections.max(list);
        System.out.println(max);//765

        //Object min(Collection)
        Comparable min = Collections.min(list);
        System.out.println(min);//-97

        //int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
        int frequency = Collections.frequency(list, 123);
        System.out.println(frequency);//3

        //void copy(List dest,List src)：将src中的内容复制到dest中
        List dest = Arrays.asList(new Object[list.size()]);
        System.out.println(dest.size());//7
        Collections.copy(dest, list);
        System.out.println(dest);//[123, 123, 123, 43, 765, -97, 0]
        //boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换 List 对象的所有旧值
    }


    /**
     * reverse(List)：反转 List 中元素的顺序
     * shuffle(List)：对 List 集合元素进行随机排序
     * sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
     * sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
     * swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
     * <p>
     */
    @Test
    public void test1() {
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(0);
        System.out.println(list);//[123, 43, 765, -97, 0]

        //reverse(List)：反转 List 中元素的顺序
        Collections.reverse(list);
        System.out.println(list);//[0, -97, 765, 43, 123]

        //shuffle(List)：对 List 集合元素进行随机排序
        Collections.shuffle(list);
        System.out.println(list);//[765, -97, 123, 0, 43]

        //sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
        Collections.sort(list);
        System.out.println(list);//[-97, 0, 43, 123, 765]

        //swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
        Collections.swap(list, 1, 4);
        System.out.println(list);//[-97, 765, 43, 123, 0]

    }
}
