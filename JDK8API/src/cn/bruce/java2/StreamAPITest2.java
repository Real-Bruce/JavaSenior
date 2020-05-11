package cn.bruce.java2;

import cn.bruce.java1.Employee;
import cn.bruce.java1.EmployeeData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 测试Stream的中间操作
 * @author bruce
 * @project_name JavaSenior
 * @package_name cn.bruce.java2
 * @create 2020-05-08 08:23
 */
public class StreamAPITest2 {
    //1-筛选与切片,注意执行终止操作后，Stream流就被关闭了，使用时需要再次创建Stream流
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();
        //filter(Predicate p)——接收 Lambda ， 从流中排除某些元素。
        Stream<Employee> employeeStream = employees.stream();
        //练习：查询员工表中薪资大于7000的员工信息
        employeeStream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);

        //limit(n)——截断流，使其元素不超过给定数量。
        employeeStream.limit(3).forEach(System.out::println);
        System.out.println();

        //skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
        employeeStream.skip(3).forEach(System.out::println);
        //distinct()——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
        employees.add(new Employee(1010,"刘庆东",56,8000));
        employees.add(new Employee(1010,"刘庆东",56,8000));
        employees.add(new Employee(1010,"刘庆东",56,8000));
        employees.add(new Employee(1010,"刘庆东",56,8000));

        employeeStream.distinct().forEach(System.out::println);
    }

    //2-映射
    @Test
    public void test2(){
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        //map(Function f)——接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);

        //练习1：获取员工姓名长度大于3的员工的姓名。
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> nameStream = employees.stream().map(Employee::getName);
        nameStream.filter(name -> name.length() >3).forEach(System.out::println);
        System.out.println();
        //练习2：使用map()中间操作实现flatMap()中间操作方法
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest2::fromStringToStream);
        streamStream.forEach(s ->{
            s.forEach(System.out::println);
        });
        System.out.println();
        //flatMap(Function f)——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
        Stream<Character> characterStream = list.stream().flatMap(StreamAPITest2::fromStringToStream);
        characterStream.forEach(System.out::println);

    }
    //将字符串中的多个字符构成的集合转换为对应的Stream的实例
    public static Stream<Character>fromStringToStream(String str){
        ArrayList<Character> list = new ArrayList<>();
        for (Character c :
                str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }
    //map()和flatMap()方法类似于List中的add()和addAll()方法
    @Test
    public void test(){
        ArrayList<Object> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);

        ArrayList<Object> list2 = new ArrayList<>();
        list2.add(5);
        list2.add(6);
        list2.add(7);
        list2.add(8);

        list1.add(list2);
        System.out.println(list1);//[1, 2, 3, 4, [5, 6, 7, 8]]
        list1.addAll(list2);
        System.out.println(list1);//[1, 2, 3, 4, [5, 6, 7, 8], 5, 6, 7, 8]

    }

    //3-排序
    @Test
    public void test3(){
        //sorted()——自然排序
        List<Integer> list = Arrays.asList(12, 34, 54, 65, 32);
        list.stream().sorted().forEach(System.out::println);

        //抛异常，原因:Employee没有实现Comparable接口
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted().forEach(System.out::println);

        //sorted(Comparator com)——定制排序
        List<Employee> employees1 = EmployeeData.getEmployees();
        employees1.stream().sorted((e1,e2)->{
            int ageValue = Integer.compare(e1.getAge(), e2.getAge());
            if (ageValue != 0){
                return ageValue;
            }else {
                return -Double.compare(e1.getSalary(),e2.getSalary());
            }

        }).forEach(System.out::println);


    }
}
