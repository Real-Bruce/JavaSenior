package com.bruce.java;

/**
 * @author bruce
 * @project_name JavaSenior
 * @package_name com.bruce.java
 * @create 2020-04-26 11:34
 */
public class EnumTest {
    public static void main(String[] args) {
        Season1 autumn = Season1.AUTUMN;
        //toString方法：返回枚举类对象的方法
        System.out.println(autumn.toString());
        System.out.println("*********************");
        //values():返回所有的枚举类对象构成的数组
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            values[i].show();
        }
        System.out.println("////////////////");
        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++) {
            System.out.println(values1[i]);
        }
        //valueOf(String objName):返回类对象名是objName的对象
        Season1 winter = Season1.valueOf("WINTER");
//        Season1 winter = Season1.valueOf("WINTER1");
        System.out.println(winter);
    }
}
interface Info {
    void show();
}

enum Season1 implements Info{
    //1.提供当前枚举类的对象，多个对象用","隔开，末尾用";"结束
    SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春天你好！");
        }
    },
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println("夏天你好！");
        }
    },
    AUTUMN("秋天","秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天你好！");
        }
    },
    WINTER("冬天","冰天雪地"){
        @Override
        public void show() {
            System.out.println("冬天你好！");
        }
    };
    //2.声明Season1对象的属性：private final修饰
    private final String seasonName;
    private final String seasonDesc;
    //3.私有化构造器，并给属性赋值
    private Season1(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }
    //4.其他诉求1：获取枚举对象的属性

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
}
