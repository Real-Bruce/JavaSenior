package com.bruce.java;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author bruce
 * @project_name JavaSenior
 * @package_name com.bruce.java
 * @create 2020-04-15 11:31
 */
//1.创建实现callable接口的实现类
class NumThread implements Callable {
    //2.实现call方法，将需要执行的线程操作放到call()中
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //3.创建Callable接口实现类
        NumThread numThread = new NumThread();
        //4.将Callable接口实现类的对象传递到FutureTask构造器中，创建FutureTask对象
        FutureTask futureTask = new FutureTask(numThread);
        //5.将FutureTask对象作为参数传递到Thread类的构造器中，创建Tread对象，并调用start（）
        new Thread(futureTask).start();
        //6.获取Callable中call方法的返回值
        Object obj = futureTask.get();
        System.out.println("总和为"+obj);
        //get()返回值即为FutureTask构造器参数Callable实现类重写的call()的返回值。
    }
}
