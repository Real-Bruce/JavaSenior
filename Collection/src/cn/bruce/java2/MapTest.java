package cn.bruce.java2;

import org.junit.Test;

import java.util.*;

/**
 * @author bruce
 * @project_name JavaSenior
 * @package_name cn.bruce.java2
 * @create 2020-04-29 14:53
 */

/**
 * Map中定义的方法：
 * 添加、删除、修改操作：
 * Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
 * void putAll(Map m):将m中的所有key-value对存放到当前map中
 * Object remove(Object key)：移除指定key的key-value对，并返回value
 * void clear()：清空当前map中的所有数据
 * 元素查询的操作：
 * Object get(Object key)：获取指定key对应的value
 * boolean containsKey(Object key)：是否包含指定的key
 * boolean containsValue(Object value)：是否包含指定的value
 * int size()：返回map中key-value对的个数
 * boolean isEmpty()：判断当前map是否为空
 * boolean equals(Object obj)：判断当前map和参数对象obj是否相等
 * 元视图操作的方法：
 * Set keySet()：返回所有key构成的Set集合
 * Collection values()：返回所有value构成的Collection集合
 * Set entrySet()：返回所有key-value对构成的Set集合
 * <p>
 * 总结：常用方法：
 * 添加：put(Object key,Object value)
 * 删除：remove(Object key)
 * 修改：put(Object key,Object value)
 * 查询：get(Object key)
 * 长度：size()
 * 遍历：keySet() / values() / entrySet()
 */
public class MapTest {
    /**
     * 添加、删除、修改操作：
     * Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
     * void putAll(Map m):将m中的所有key-value对存放到当前map中
     * Object remove(Object key)：移除指定key的key-value对，并返回value
     * void clear()：清空当前map中的所有数据
     */
    @Test
    public void test1() {
        Map map = new HashMap();
        //Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
        map.put("AA", 123);
        map.put("ZZ", 251);
        map.put("CC", 110);
        map.put("RR", 124);
        map.put("FF", 662);
        System.out.println(map);//{AA=123, ZZ=251, CC=110, RR=124, FF=662}

        //Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
        map.put("ZZ", 261);
        System.out.println(map);//{AA=123, ZZ=261, CC=110, RR=124, FF=662}

        //void putAll(Map m):将m中的所有key-value对存放到当前map中
        HashMap map1 = new HashMap();
        map1.put("GG", 435);
        map1.put("DD", 156);
        map.putAll(map1);
        System.out.println(map);//{AA=123, ZZ=261, CC=110, RR=124, FF=662, GG=435, DD=156}

        //Object remove(Object key)：移除指定key的key-value对，并返回value
        Object value = map.remove("GG");
        System.out.println(value);//435
        System.out.println(map);//{AA=123, ZZ=261, CC=110, RR=124, FF=662, DD=156}

        //void clear()：清空当前map中的所有数据
        map.clear();
        System.out.println(map.size());//0  与map = null操作不同
        System.out.println(map);//{}
    }

    /**
     * 元素查询的操作：
     * Object get(Object key)：获取指定key对应的value
     * boolean containsKey(Object key)：是否包含指定的key
     * boolean containsValue(Object value)：是否包含指定的value
     * int size()：返回map中key-value对的个数
     * boolean isEmpty()：判断当前map是否为空
     * boolean equals(Object obj)：判断当前map和参数对象obj是否相等
     */
    @Test
    public void test2() {
        Map map = new HashMap();
        map.put("AA", 123);
        map.put("ZZ", 251);
        map.put("CC", 110);
        map.put("RR", 124);
        map.put("FF", 662);
        System.out.println(map);//{AA=123, ZZ=251, CC=110, RR=124, FF=662}
        //Object get(Object key)：获取指定key对应的value
        System.out.println(map.get("AA"));//123

        //boolean containsKey(Object key)：是否包含指定的key
        System.out.println(map.containsKey("ZZ"));//true

        //boolean containsValue(Object value)：是否包含指定的value
        System.out.println(map.containsValue(123));//true

        //int size()：返回map中key-value对的个数
        System.out.println(map.size());//5

        //boolean isEmpty()：判断当前map是否为空
        System.out.println(map.isEmpty());//false

        //boolean equals(Object obj)：判断当前map和参数对象obj是否相等
        Map map1 = new HashMap();
        map1.put("AA", 123);
        map1.put("ZZ", 251);
        map1.put("CC", 110);
        map1.put("RR", 124);
        map1.put("FF", 662);
        System.out.println(map.equals(map1));//true
    }

    /**
     * 元视图操作的方法：
     * Set keySet()：返回所有key构成的Set集合
     * Collection values()：返回所有value构成的Collection集合
     * Set entrySet()：返回所有key-value对构成的Set集合
     */
    @Test
    public void test3() {
        Map map = new HashMap();
        map.put("AA", 123);
        map.put("ZZ", 251);
        map.put("CC", 110);
        map.put("RR", 124);
        map.put("FF", 662);
        System.out.println(map);//{AA=123, ZZ=251, CC=110, RR=124, FF=662}
        //遍历所有的key集:Set keySet()：返回所有key构成的Set集合
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("--------------");
        //遍历所有的value集：Collection values()：返回所有value构成的Collection集合
        Collection values = map.values();
        for (Object obj :
                values) {
            System.out.println(obj);
        }
        System.out.println("---------------");
        //Set entrySet()：返回所有key-value对构成的Set集合
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        //方式一：
        while (iterator1.hasNext()) {
            Object obj = iterator1.next();
            //entrySet集合中的元素都是entry
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }
        System.out.println("--------------");

        //方式二：
        Set keySet = map.keySet();
        Iterator iterator2 = keySet.iterator();
        while (iterator2.hasNext()) {
            Object key = iterator2.next();
            Object value = map.get(key);
            System.out.println(key + "==" + value);
        }
    }
}
