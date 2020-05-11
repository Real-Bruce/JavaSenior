package com.bruce.java;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author bruce
 * @project_name JavaSenior
 * @package_name com.bruce.java
 * @create 2020-04-19 09:07
 */
public class StringChangeTest {
    /**
     * String和基本数据类型间的转化
     * String --> 基本数据类型、包装类：调用包装类的静态方法：parseXxx(str)
     * 基本数据类型、包装类 --> String:调用String重载的valueOf(xxx)
     */
    @Test
    public void stringToBasicTest() {
        String str1 = "123";
        int i = Integer.parseInt(str1);
        System.out.println(i);
        System.out.println(i == 123);//true

        int j = 456;
        String s = String.valueOf(j);
        System.out.println(s);
        System.out.println(s.equals("456"));//true
    }

    /**
     * String和字符型之间的转化
     * String --> char[]:调用String的toCharArray()
     * char[] --> String:调用String的构造器
     */
    @Test
    public void basicToStringTest() {
        String s1 = "helloword";
        char[] chars = s1.toCharArray();
        for (char aChar : chars) {
            System.out.println(aChar);
        }

        char[] charArray = new char[]{'h', 'e', 'l', 'l', 'o'};
        String s2 = new String(charArray);
        System.out.println(s2);
    }

    /**
     * 编码：String --> byte[]:调用String的getBytes()
     * 解码：byte[] --> String:调用String的构造器
     * <p>
     * 编码：字符串 -->字节  (看得懂 --->看不懂的二进制数据)
     * 解码：编码的逆过程，字节 --> 字符串 （看不懂的二进制数据 ---> 看得懂
     * <p>
     * 说明：解码时，要求解码使用的字符集必须与编码时使用的字符集一致，否则会出现乱码。
     */
    @Test
    public void stringToByteTest() throws UnsupportedEncodingException {
        String s1 = "你好java世界";
        byte[] bytesArray = s1.getBytes();//使用默认字符集编码
        System.out.println(Arrays.toString(bytesArray));//[-28, -67, -96, -27, -91, -67, 106, 97, 118, 97, -28, -72, -106, -25, -107, -116]

        byte[] gbks = s1.getBytes("gbk");//使用gbk编码集合
        System.out.println(Arrays.toString(gbks));//[-60, -29, -70, -61, 106, 97, 118, 97, -54, -64, -67, -25]

        System.out.println("--------------------------------");

        String str1 = new String(bytesArray);//使用默认字符进行解码
        System.out.println(str1);//你好java世界

        String str2 = new String(gbks);//使用默认字符对gbk编码进行解码
        System.out.println(str2);//���java����解码错误，出现中文乱码,原因：编码和解码不一致

        String str3 = new String(gbks, "gbk");//使用gbk格式进行解码
        System.out.println(str3);//你好java世界，解码正确，原因：编码和解码一致

    }

    @Test
    public void stringToStringBufferTest() {
        String str1 = "helloword";

        StringBuffer stringBuffer = new StringBuffer(str1);
        System.out.println(stringBuffer);//helloword

        StringBuilder stringBuilder = new StringBuilder(str1);
        System.out.println(stringBuilder);//helloword

        stringBuffer.append("isStringBuffer");
        System.out.println(stringBuffer);//hellowordandgood

        stringBuilder.append("isStringBuider");
        System.out.println(stringBuilder);
    }

    @Test
    public void stringBuiderOrStringBufferToStringTest() {
        StringBuffer sb1 = new StringBuffer("hello StringBuffer");
        System.out.println(sb1);

        StringBuilder sb2 = new StringBuilder("hello StringBuider");
        System.out.println(sb2);

        System.out.println("----------------------");

        String str1 = new String(sb1);
        System.out.println(str1);

        String str2 = new String(sb2);
        System.out.println(str2);

        System.out.println("----------------------");
        System.out.println(sb1.toString());
        System.out.println(sb2.toString());
    }


}
