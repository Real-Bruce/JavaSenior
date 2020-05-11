package com.bruce.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author bruce
 * @project_name JavaSenior
 * @package_name com.bruce.java
 * @create 2020-04-19 13:32
 */
public class DateTest {
    @Test
    public void dateTest() {
        //构造器一：Date()：创建一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toString());//Sun Apr 19 13:35:12 CST 2020
        System.out.println(date1.getTime());//1587274512876

        //构造器二：创建指定毫秒数的Date对象
        Date date2 = new Date(15872745176L);
        System.out.println(date2.toString());
        System.out.println("-----------------------");

        //创建java.sql.Date对象
        java.sql.Date date3 = new java.sql.Date(1587274512876L);
        System.out.println(date3.toString());

        //如何将java.util.Date对象转换为java.sql.Date对象
        Date date4 = new Date();
        //第一种方式，存在问题：java.util.Date cannot be cast to java.sql.Date
//        java.sql.Date date6 = (java.sql.Date) date4;
//        System.out.println(date6);
        //第二种方式
        java.sql.Date date5 = new java.sql.Date(date4.getTime());
        System.out.println(date5);
    }

    @Test
    public void test2() throws ParseException {
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:aaa");
        //格式化date对象
        String format = simpleDateFormat.format(date1);
        System.out.println(format.toString());//2020-09-19 02:09:下午
        //解析:要求字符串必须是符合SimpleDateFormat识别的格式(通过构造器参数体现),
        //否则，抛异常
        Date date2 = simpleDateFormat.parse("2020-04-20 14:20:下午");
        System.out.println(date2.toString());//Tue Jan 21 02:20:00 CST 2020
    }

    @Test
    public void test3() throws ParseException {
        String brith = "1997-10-15";
        //新建SimpleDateFormat对象并设置时间格式
        SimpleDateFormat simpBrith = new SimpleDateFormat("yyyy-mm-dd");
        //将字符串格式的时间格式化为Date类
        Date brithday = simpBrith.parse(brith);
        //通过Date的getTime方法将Date对象转化为时间戳放到java.sql.date类的构造方法中
        java.sql.Date brithDate = new java.sql.Date(brithday.getTime());
        System.out.println(brithDate);
    }

    @Test
    public void test4() {
        Calendar calendar = Calendar.getInstance();
        //        System.out.println(calendar.getClass());

        //2.常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        //set()
        //calendar可变性
        calendar.set(Calendar.DAY_OF_MONTH, 22);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //add()
        calendar.add(Calendar.DAY_OF_MONTH, -3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //getTime():日历类---> Date
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime():Date ---> 日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
    }
}
