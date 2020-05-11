package com.bruce.java;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * @author bruce
 * @project_name JavaSenior
 * @package_name com.bruce.java
 * @create 2020-04-21 18:43
 */
public class JDK8TimeTest {
    /**
     * LocalDate/LocalTime/LocalDateTime类
     */
    @Test
    public void test1(){
        //now():获取当前的日期、时间、日期时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);//2020-04-21
        System.out.println(localTime);//18:52:54.929
        System.out.println(localDateTime);//2020-04-21T18:52:54.929

        //of():设置指定的年、月、日、时、分、秒。没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2020,10,6,12,13,12);
        System.out.println(localDateTime1);//2020-10-06T12:13:12

        //getXxx()：获取相关的属性
        System.out.println(localDateTime.getDayOfMonth());//21
        System.out.println(localDateTime.getDayOfWeek());//TUESDAY
        System.out.println(localDateTime.getMonth());//APRIL
        System.out.println(localDateTime.getMonthValue());//4
        System.out.println(localDateTime.getMinute());//52

        //体现不可变性
        //withXxx():设置相关的属性
        LocalDate localDate1 = localDate.withDayOfMonth(22);
        System.out.println(localDate);//2020-04-21
        System.out.println(localDate1);//2020-04-22

        LocalDateTime localDateTime2 = localDateTime.withHour(4);
        System.out.println(localDateTime);//2020-04-21T18:59:17.484
        System.out.println(localDateTime2);//2020-04-21T04:59:17.484

        //不可变性
        LocalDateTime localDateTime3 = localDateTime.plusMonths(3);
        System.out.println(localDateTime);//2020-04-21T18:59:17.484
        System.out.println(localDateTime3);//2020-07-21T18:59:17.484

        LocalDateTime localDateTime4 = localDateTime.minusDays(6);
        System.out.println(localDateTime);//2020-04-21T18:59:17.484
        System.out.println(localDateTime4);//2020-04-15T18:59:17.484
    }

    /**
     * instant时间瞬时点
     */
    @Test
    public void test2(){
        //now():获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);//2020-04-21T11:03:21.469Z

        //添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);//2020-04-21T19:03:21.469+08:00

        //toEpochMilli():获取自1970年1月1日0时0分0秒（UTC）开始的毫秒数  ---> Date类的getTime()
        long milli = instant.toEpochMilli();
        System.out.println(milli);//1587467105795

        //ofEpochMilli():通过给定的毫秒数，获取Instant实例  -->Date(long millis)
        Instant instant1 = Instant.ofEpochMilli(1587467105795L);
        System.out.println(instant1);//2020-04-21T11:05:05.795Z
    }

    @Test
    public void test3(){
        //        方式一：预定义的标准格式。
        //        如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化:日期-->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
        System.out.println(localDateTime);//2020-04-21T19:13:13.530
        System.out.println(str1);//2020-04-21T19:13:13.53

        //解析：字符串 -->日期
        TemporalAccessor parse = formatter.parse("2000-04-21T19:13:13.53");
        System.out.println(parse);//{},ISO resolved to 2000-04-21T19:13:13.530
        //        方式二：
        //        本地化相关的格式。如：ofLocalizedDateTime()
        //        FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT :适用于LocalDateTime
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        //格式化
        String str2 = formatter1.format(localDateTime);
        System.out.println(str2);//2020年4月21日 下午07时16分57秒

        //      本地化相关的格式。如：ofLocalizedDate()
        //      FormatStyle.FULL / FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT : 适用于LocalDate
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        //格式化
        String str3 = formatter2.format(LocalDate.now());
        System.out.println(str3);//2020-4-21

        //       重点： 方式三：自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String Str4 = formatter3.format(LocalDateTime.now());
        System.out.println(Str4);//2020-04-21 07:24:04

        TemporalAccessor accessor = formatter3.parse("2020-02-03 05:23:06");
        System.out.println(accessor);//{SecondOfMinute=6, HourOfAmPm=5, NanoOfSecond=0, MicroOfSecond=0, MinuteOfHour=23, MilliOfSecond=0},ISO resolved to 2020-02-03
    }
}
