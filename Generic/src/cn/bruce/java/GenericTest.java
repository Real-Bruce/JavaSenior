package cn.bruce.java;

import org.junit.Test;

import java.util.*;

/**
 * @author bruce
 * @project_name JavaSenior
 * @package_name cn.bruce.java
 * @create 2020-04-30 08:59
 */
public class GenericTest {
    //在集合中使用泛型，以ArrayList为例
    @Test
    public void test1(){
        ArrayList<String> list = new ArrayList<>();
        list.add("AAA");
        list.add("BBB");
        list.add("FFF");
        list.add("EEE");
        list.add("CCC");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("-------------");
        for (String str:
             list) {
            System.out.println(str);
        }
    }

    @Test
    //在集合中使用泛型的情况：以HashMap为例
    public void test2(){
        Map<String,Integer> map = new HashMap<>();//jdk7新特性：类型推断
        map.put("Tom",26);
        map.put("Jarry",30);
        map.put("Bruce",28);
        map.put("Davie",60);
        //嵌套循环
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();

        while (iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key+"="+value);
        }

    }

}
