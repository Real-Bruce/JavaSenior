package cn.bruce.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author bruce
 * @project_name JavaSenior
 * @package_name cn.bruce.java
 * @create 2020-04-28 10:37
 */
public class ForeachTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(345);
        coll.add(new User("Tom",34));
        coll.add(new User("Tom"));
        coll.add(false);
        //遍历集合
        for (Object obj :
                coll) {
            System.out.println(obj);
        }
        //遍历数组
        int [] arr = new int[]{123,456,789,1233};
        for (int i :
                arr) {
            System.out.println(i);
        }
    }
}
