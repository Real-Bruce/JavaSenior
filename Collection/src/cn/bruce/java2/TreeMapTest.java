package cn.bruce.java2;

import org.junit.Test;

import java.util.*;

/**
 * @author bruce
 * @project_name JavaSenior
 * @package_name cn.bruce.java2
 * @create 2020-04-29 15:44
 */
public class TreeMapTest {
    //自然排序
    @Test
    public void test() {
        TreeMap map = new TreeMap();
        User u1 = new User("Tom", 23);
        User u2 = new User("Jarry", 18);
        User u3 = new User("Bruce", 56);
        User u4 = new User("Davie", 23);

        map.put(u1, 98);
        map.put(u2, 16);
        map.put(u3, 92);
        map.put(u4, 100);

        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    //定制排序：按照年龄大小排
    @Test
    public void test2() {
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User) {
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.getAge(), u2.getAge());
                }
                throw new RuntimeException("输入数据类型错误");
            }
        });
        User u1 = new User("Tom", 23);
        User u2 = new User("Jarry", 18);
        User u3 = new User("Bruce", 56);
        User u4 = new User("Davie", 23);

        map.put(u1, 98);
        map.put(u2, 16);
        map.put(u3, 92);
        map.put(u4, 100);

        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
