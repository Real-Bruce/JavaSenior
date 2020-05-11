package cn.bruce.java;

import org.junit.Test;

import java.util.Comparator;

/**
 * Lambda表达式的使用举例
 * @author bruce
 * @project_name JavaSenior
 * @package_name cn.bruce.java
 * @create 2020-05-07 19:04
 */
public class LambdaTest1 {
    @Test
    public void test1(){
        //未使用Lamdba表达式的写法
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello Lamdba!");
            }
        };
        r1.run();

        System.out.println("========================");
        //Lamdba表达式写法
        Runnable r2 = () -> System.out.println("hi Lamdba!");
        r2.run();
    }

    @Test
    public void test2(){
        //未使用Lamdba表达式的写法
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        int compare1 = com1.compare(12, 32);
        System.out.println(compare1);//-1
        System.out.println("===================");

        //Lambda表达式的写法
        Comparator<Integer> com2 = (o1,o2) -> Integer.compare(o1,o2);

        int compare2 = com2.compare(54, 21);
        System.out.println(compare2);//1
        System.out.println("===================");

        //方法引用
        Comparator<Integer> cpm3 = Integer::compareTo;
        int compare3 = cpm3.compare(12, 12);
        System.out.println(compare3);//0
    }
}
