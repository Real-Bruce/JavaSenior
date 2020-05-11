package cn.bruce.java;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author bruce
 * @project_name JavaSenior
 * @package_name cn.bruce.java
 * @create 2020-05-06 13:44
 */
public class ReflectionTest {


    //通过反射操作Person对象
    @Test
    public void test1() throws Exception {
        Class<Person> clazz = Person.class;
        //1.通过反射，创建Person类对象
        Constructor<Person> cons = clazz.getConstructor(String.class, int.class);
        Person person = cons.newInstance("Tom", 12);
        System.out.println(person);//Person{name='Tom', age=12}

        //2.通过反射，调用对象指定的属性、方法
        //调用属性
        Field age = clazz.getDeclaredField("age");
        age.setAccessible(true);
        age.set(person, 10);
        System.out.println(person.toString());//Person{name='Tom', age=10}

        //调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(person);//my name is Tom and age is 10

        System.out.println("===================================");
        //通过反射，可以调用Person类的私有结构的。比如：私有的构造器、方法、属性
        //调用私有的构造器
        Constructor<Person> cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = cons1.newInstance("Bruce");
        System.out.println(p1);//Person{name='Bruce', age=0}

        //调用私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1, "Jarry");
        System.out.println(p1);

        //调用私有的方法
        Method nation = clazz.getDeclaredMethod("nation", String.class);
        nation.setAccessible(true);
        Object nation1 = (String) nation.invoke(p1, "China");//相当于String nation = p1.showNation("China")
        System.out.println(nation1);//I come from China
    }

    //获取Class的实例的方式（前三种方式需要掌握）
    @Test
    public void test2() throws ClassNotFoundException {
        //方式一：调用运行时类的属性：.class
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);//class cn.bruce.java.Person

        //方式二：通过运行时类的对象,调用getClass()
        Person p1 = new Person();
        Class<? extends Person> clazz2 = p1.getClass();
        System.out.println(clazz2);//class cn.bruce.java.Person

        //方式三：调用Class的静态方法：forName(String classPath)
        Class<?> clazz3 = Class.forName("cn.bruce.java.Person");
        System.out.println(clazz3);//class cn.bruce.java.Person

        System.out.println(clazz1 == clazz2);//true
        System.out.println(clazz1 == clazz3);//true
        //方式四：使用类的加载器：ClassLoader  (了解)
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> clazz4 = classLoader.loadClass("cn.bruce.java.Person");
        System.out.println(clazz4);//class cn.bruce.java.Person
        System.out.println(clazz1 == clazz4);//true


    }
    //万事万物皆对象？对象.xxx,File,URL,反射,前端、数据库操作
    //Class实例可以是哪些结构的说明：
    @Test
    public void test3(){
        Class<Object> c1 = Object.class;
        Class<Comparable> c2 = Comparable.class;
        Class<String[]> c3 = String[].class;
        Class<int[][]> c4 = int[][].class;
        Class<ElementType> c5 = ElementType.class;
        Class<Override> c6 = Override.class;
        Class<Integer> c7 = int.class;
        Class<Void> c8 = void.class;
        Class<Class> c9 = Class.class;

        int[] i1 = new int[10];
        int[] i2 = new int[100];
        Class<? extends int[]> c10 = i1.getClass();
        Class<? extends int[]> c11 = i2.getClass();
        // 只要数组的元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);//true
    }

}
