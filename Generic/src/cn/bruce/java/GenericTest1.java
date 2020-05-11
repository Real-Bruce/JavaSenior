package cn.bruce.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义泛型结构
 *
 * @author bruce
 * @project_name JavaSenior
 * @package_name cn.bruce.java
 * @create 2020-04-30 09:14
 */
public class GenericTest1 {
    @Test
    //测试调用泛型类
    public void test1() {
        //如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型
        //要求：如果大家定义了类是带泛型的，建议在实例化时要指明类的泛型。
        Order order = new Order();
        order.setOrderT(123);
        System.out.println(order.getOrderT());

        order.setOrderT("abc");
        System.out.println(order.getOrderT());

        //建议：实例化时指明类的泛型
        Order<String> order1 = new Order<>("Tom", 16, "male");
        order1.setOrderT("AA:BBB");
        System.out.println(order1.getOrderT());
    }

    @Test
    //测试调用泛型方法
    public void test2(){
        Order<String> order = new Order<>();
        Integer [] arr = new Integer[]{1,2,3,4,5,6};

        List<Integer> list = order.copyFromArryToList(arr);
        System.out.println(list);
    }

    @Test
    //测试泛型接口
    public void test3(){
        Demo demo = new Demo();
        demo.show();
    }
}


/**
 * 泛型类的继承关系
 * @param <T1>
 * @param <T2>
 */
class Father<T1, T2> {
}

/**
 * 定义泛型子类Son
 * 情况一：继承泛型父类后不保留父类的泛型
 */
//1.没有指明类型  擦除
class Son1<A, B> extends Father {//等价于class Son1 extends Father<Object,Odject>{}
}

//2.指定具体类型
class Son2<A, B> extends Father<Integer, String> {
}

/**
 * 定义泛型子类Son
 * 情况二：继承泛型父类后保留泛型类型
 */
//1.全部保留
class Son3<T1, T2, A, B> extends Father<T1, T2> {
}

//2.部分保留
class Son4<T2, A, B> extends Father<Integer,T2>{
}


/**
 * 自定义泛型类Order
 */
class Order<T> {
    private String orderName;
    private int orderId;
    //使用T类型定义变量
    private T orderT;

    public Order() {
    }
    //使用T类型定义构造器
    public Order(String orderName, int orderId, T orderT) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    //这个不是泛型方法
    public T getOrderT() {
        return orderT;
    }
    //这个不是泛型方法
    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }
    //这个不是泛型方法
    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }
//    //静态方法中不能使用类的泛型。
//    public static void show(T orderT){
//        System.out.println(orderT);
//    }

//    //try-catch中不能是泛型的。
//    public void show(){
//        try {
//
//        }catch (T t){
//
//        }
//    }

    //泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系。
    //换句话说，泛型方法所属的类是不是泛型类都没有关系。
    //泛型方法，可以声明为静态的。
    // 原因：泛型参数是在调用方法时确定的。并非在实例化类时确定。
    public static <E> List<E> copyFromArryToList(E[] arr) {
        ArrayList<E> list = new ArrayList<>();
        for (E e :
                arr) {
            list.add(e);
        }
        return list;
    }
}


