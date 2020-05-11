package cn.bruce.java1;

import java.io.Serializable;

/**
 * @author bruce
 * @project_name JavaSenior
 * @package_name cn.bruce.java1
 * @create 2020-05-04 21:13
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 1616515615L;

    private String name;
    private int age;
    private int id;
    private Account account;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, int id, Account account) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                ", account=" + account +
                '}';
    }
}

class Account implements Serializable {
    private static final long serialVersionUID = 1616523415615L;

    private double blance;

    public Account() {
    }

    public Account(double blance) {
        this.blance = blance;
    }

    public double getBlance() {
        return blance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "blance=" + blance +
                '}';
    }
}
