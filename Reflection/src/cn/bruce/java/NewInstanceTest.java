package cn.bruce.java;

import org.junit.Test;

import java.util.Random;

/**
 * @author bruce
 * @project_name JavaSenior
 * @package_name cn.bruce.java
 * @create 2020-05-06 15:08
 */
public class NewInstanceTest {
    @Test
    public void test1() throws Exception {
        Class<Person> clazz1 = Person.class;
        Class<Person> clazz2 = (Class<Person>) Class.forName("cn.bruce.java.Person");

        Person person1 = clazz1.newInstance();
        Person person2 = clazz2.newInstance();
        System.out.println(person1);
        System.out.println(person2);

    }

    //体会反射的动态性
    @Test
    public void test2() {
        for (int i = 0; i < 100; i++) {
            int num = new Random().nextInt(3);
            String classPath = "";
            switch (num){
                case 0:
                    classPath="java.util.Date";
                    break;
                case 1:
                    classPath="java.lang.Object";
                    break;
                case 2:
                    classPath="cn.bruce.java.Person";
                    break;
            }
            Object instance = null;
            try {
                instance = getInstance(classPath);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println(instance);
        }
    }

    /*
    创建一个指定类的对象。
    classPath:指定类的全类名
     */
    public Object getInstance(String ClassPath) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Class<?> clazz = Class.forName(ClassPath);
        return clazz.newInstance();
    }

}
