package com.bruce.java;

import org.junit.Test;

/**
 * @author bruce
 * @project_name JavaSenior
 * @package_name com.bruce.java
 * @create 2020-04-19 11:03
 */
public class StringBufferTest {
    /**
     * 1. StringBuffer append(xxx)：提供了很多的append()方法，用于进行字符串拼接
     * 2. StringBuffer delete(int start,int end)：删除指定位置的内容
     * 3. StringBuffer replace(int start, int end, String str)：把[start,end)位置替换为str
     * 4. StringBuffer insert(int offset, xxx)：在指定位置插入xxx
     * 5. StringBuffer reverse() ：把当前字符序列逆转
     *
     * - public int indexOf(String str)：返回子串的下标
     * - public String substring(int start,int end):返回一个从start开始到end索引结束的左闭右开区间的子字符串
     * - public int length()：获取字符串的长度
     * - public char charAt(int n )：返回指定位置的字符
     * - public void setCharAt(int n ,char ch)：设置指定位置的字符
     */
    @Test
    public void stringBufferMethodTest(){
        StringBuffer s1 = new StringBuffer("abc");
        System.out.println(s1);

        System.out.println(s1.append("1"));//abc1
        System.out.println(s1.delete(0, 1));//bc1
        System.out.println(s1.replace(0, 1, "hello"));//helloc1
        System.out.println(s1.insert(3, "v"));//helvloc1
        System.out.println(s1.reverse());//1colvleh
    }

    @Test
    public void test3(){
        //初始设置
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");
        //开始对比
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间：" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间：" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间：" + (endTime - startTime));

    }
}
