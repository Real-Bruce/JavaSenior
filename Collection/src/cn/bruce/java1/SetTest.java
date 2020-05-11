package cn.bruce.java1;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author bruce
 * @project_name JavaSenior
 * @package_name cn.bruce.java1
 * @create 2020-04-28 14:55
 */
public class SetTest {
    @Test
    //HashSet使用
    public void test1(){
        Set set = new HashSet();
        set.add(454);
        set.add(213);
        set.add(111);
        set.add(123);
        set.add(23);
        set.add("AAA");
        set.add("EEE");
        set.add(new User("Tom",34));
        set.add(new User("Jarry",74));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    //LinkedHashSet使用
    public void test2(){
        Set set = new LinkedHashSet();
        set.add(454);
        set.add(213);
        set.add(111);
        set.add(123);
        set.add(23);
        set.add("AAA");
        set.add("EEE");
        set.add(new User("Tom",34));
        set.add(new User("Jarry",74));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
