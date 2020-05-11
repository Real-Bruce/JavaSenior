package cn.bruce.java1;

/**
 * @author bruce
 * @project_name JavaSenior
 * @package_name cn.bruce.java1
 * @create 2020-05-06 15:23
 */
@MyAnnotation(value = "hi")
public class Person extends Creature implements MyInterface, Comparable {
    private String name;
    int age;
    public int id;

    public Person() {
    }

    //私有的构造器
    @MyAnnotation(value = "123")
    private Person(String name) {
        this.name = name;
    }

    public Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @MyAnnotation
    private String show(String nation) {
        return "我的国籍是" + nation;
    }

    public String display(String intersts, int age) {
        return intersts + age;
    }
    private static void showDesc(){
        System.out.println("我是个好人");
    }


    @Override
    public void info() {
        System.out.println("我是一个好人");
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
