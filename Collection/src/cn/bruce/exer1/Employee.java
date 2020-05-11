package cn.bruce.exer1;

/**
 * @author bruce
 * @project_name JavaSenior
 * @package_name cn.bruce.exer1
 * @create 2020-04-28 16:38
 */

/**
 *  定义一个Employee类。
 *  该类包含：private成员变量name,age,birthday，其中 birthday 为 MyDate 类的对象；
 *  并为每一个属性定义 getter, setter 方法；
 *  并重写 toString 方法输出 name, age, birthday
 */
public class Employee implements Comparable {
    private String name;
    private  int age;
    private MyDate brithday;

    public Employee() {
    }

    public Employee(String name, int age, MyDate brithday) {
        this.name = name;
        this.age = age;
        this.brithday = brithday;
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

    public MyDate getBrithday() {
        return brithday;
    }

    public void setBrithday(MyDate brithday) {
        this.brithday = brithday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", brithday=" + brithday +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Employee){
            Employee employee = (Employee)o;
            return this.name.compareTo(employee.name);
        }
        throw new RuntimeException("传入的数据类型不一致");
    }
}
