package com.bruce.java;

/**
 * @author bruce
 * @project_name JavaSenior
 * @package_name com.bruce.java
 * @create 2020-04-14 22:38
 */
public class SingleTest {
    //1.私有化构造器
    private SingleTest() {
    }

    private static SingleTest instance = null;

    //2.提供获取对象的方法
    public static SingleTest getInstance() {
////方式一：效率较差
//        synchronized (SingleTest.class){
//            if (instance==null){
//                instance = new SingleTest();
//            }
//            return instance;
//        }
        //方式二：效率更高
        if (instance == null) {
            synchronized (SingleTest.class) {
                if (instance == null) {
                    instance = new SingleTest();
                }
            }
        }
        return instance;
    }


}
