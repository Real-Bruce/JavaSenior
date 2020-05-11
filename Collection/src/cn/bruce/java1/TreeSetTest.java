package cn.bruce.java1;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author bruce
 * @project_name JavaSenior
 * @package_name cn.bruce.java
 * @create 2020-04-28 14:11
 */
public class TreeSetTest {
    @Test
    public void test1(){
        Set treeSet = new TreeSet();
        treeSet.add(new User("Tom",34));
        treeSet.add(new User("Jarry",23));
        treeSet.add(new User("mars",38));
        treeSet.add(new User("Jane",56));
        treeSet.add(new User("Jane",60));
        treeSet.add(new User("Bruce",58));

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    
    @Test
    public void test2(){
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User){
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.getAge(),u2.getAge());
                }else {
                    throw new RuntimeException("输入数据错误");
                }
            }
        };

        Set treeSet = new TreeSet(comparator);
        treeSet.add(new User("Tom",34));
        treeSet.add(new User("Jarry",23));
        treeSet.add(new User("mars",38));
        treeSet.add(new User("Jane",56));
        treeSet.add(new User("Jane",60));
        treeSet.add(new User("Bruce",58));

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
