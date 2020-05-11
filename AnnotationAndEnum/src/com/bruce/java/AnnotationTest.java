package com.bruce.java;

import org.junit.Test;

import java.lang.annotation.Annotation;

/**
 * @author bruce
 * @project_name JavaSenior
 * @package_name com.bruce.java
 * @create 2020-04-26 10:58
 */
public class AnnotationTest {
    /**
     *程序的主方法
     * @param args 传入命令行参数
     */
    public static void main(String[] args) {

    }

    @Test
    public void testGetAnnotation(){
        Class<Student> clazz = Student.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            System.out.println(annotations[i]);
        }
    }


    @MyAnnotation("类")
    @MyAnnotation
    class Person{
        private String name;
        private int age;

        public Person() {
        }
        @MyAnnotation("方法")
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        @MyAnnotation
        public void walk(){
            System.out.println("人走路");
        }
        public void eat(){
            System.out.println("人吃饭");
        }
    }

    interface Info{
        void show();
    }

    class Student extends Person implements Info{
        @Override
        public @MyAnnotation void walk() {
            System.out.println("学生走路");
        }

        @Override
        public void show() {

        }
    }
}
