package cn.bruce.exer;

import java.util.*;

/**
 * @author bruce
 * @project_name JavaSenior
 * @package_name cn.bruce.exer
 * @create 2020-04-29 08:15
 */
public class Exer2 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(123);
        list.add(123);
        list.add(456);
        list.add(234);
        list.add(789);
        list.add(456);
        List list2 = duplicateList(list);
        Iterator iterator = list2.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    public static List duplicateList (List list){
        Set set = new HashSet();
        set.addAll(list);
        return new ArrayList(set);
    }

}
