package cn.bruce.java4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Bruce
 * @create 2020-09-09 9:13
 */
public class testReflection {
    // 循环次数10亿次
    private static final int loopCnt = 1000 * 1000 * 1000;

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // 输出jdk版本
        System.out.println("java version is" + System.getProperty("java.version"));
        creatNewObject();
        optionObject();
        reflectCreatObject();
    }

    // person对象
    static class Person {
        private Integer age = 20;

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }

    // 每次创建新对象
    public static void creatNewObject() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loopCnt; i++) {
            Person person = new Person();
            person.setAge(30);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("循环十亿次创建对象所需的时间：" + (endTime - startTime));
    }

    // 为同一个对象赋值
    public static void optionObject() {
        long startTime = System.currentTimeMillis();
        Person p = new Person();
        for (int i = 0; i < loopCnt; i++) {
            p.setAge(10);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("循环十亿次为同一对象赋值所需的时间：" + (endTime - startTime));
    }

    // 通过反射创建对象
    public static void reflectCreatObject() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        long startTime = System.currentTimeMillis();
        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();
        Method setAge = personClass.getMethod("setAge", Integer.class);
        for (int i = 0; i < loopCnt; i++) {
            setAge.invoke(person, 90);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("循环十亿次反射创建对象所需的时间：" + (endTime - startTime));
    }
}
