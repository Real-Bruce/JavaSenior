package com.bruce.exer;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author bruce
 * @project_name JavaSenior
 * @package_name com.bruce.exer
 * @create 2020-04-18 15:03
 */
public class Exer1 {
    /**
     * * 1.模拟一个trim方法，去除字符串两端的空格。
     *
     * @param str
     * @return string
     */
    public String myTrim(String str) {
        if (str != null) {
            int start = 0;//记录从前往后首次索引位置不是空格的位置索引
            int end = str.length() - 1;//记录从后往前首次索引位置不是空格的位置索引
            while (start < end && str.charAt(start) == ' ') {
                start++;
            }
            while (start < end && str.charAt(end) == ' ') {
                end--;
            }
            if (str.charAt(start) == ' ') {
                return "";
            }
            return str.substring(start, end + 1);
        }

        return null;
    }

    @Test
    public void test1() {
        String s1 = " adaf ";
        String newStr = myTrim(s1);
        System.out.println(newStr);

    }

    /**
     * 2.将一个字符串进行反转。将字符串中指定部分进行反转。比如将“abcdefg”反转为”abfedcg”
     */
    //方式一
    public String reverse1(String str, int start, int end) {
        if (str != null) {
            //1.转换成char型数组
            char[] charArray = str.toCharArray();
            //2.进行反转操作
            for (int i = start, j = end; i < j; i++, j--) {
                char temp = charArray[i];
                charArray[i] = charArray[j];
                charArray[j] = temp;
            }
            //3.返回值
            return new String(charArray);
        }
        return null;
    }

    //方式二
    public String reverse2(String string, int start, int end) {
        String newStr = string.substring(0, start);
        for (int i = end; i >= start; i--) {
            newStr += string.charAt(i);
        }
        newStr += string.substring(end + 1);

        return newStr;
    }

    //方式三
    public String reverse3(String str, int start, int end) {
        //1.新建StringBuffer
        StringBuffer stringBuffer = new StringBuffer(str.length());
        //2.添加值
        stringBuffer.append(str.substring(0, start));
        //3.
        for (int i = end; i >= start; i--) {
            stringBuffer.append(str.charAt(i));
        }
        //4.
        stringBuffer.append(str.substring(end + 1));
        //5.
        return stringBuffer.toString();
    }

    @Test
    public void ReverseTest() {
        String s1 = "abcdefg";
        String s2 = reverse1(s1, 0, 6);
        System.out.println("s1:" + s1);
        System.out.println("s2:" + s2);

        String s3 = reverse2(s1, 0, 6);
        System.out.println("s3:" + s3);

        String s4 = reverse1(s1, 0, 6);
        System.out.println("s3:" + s3);
    }

    /**
     * 3.获取一个字符串在另一个字符串中出现的次数。
     * 比如：获取“ab”在 “cdabkkcadkabkebfkabkskab”中出现的次数
     */
    public int count(String mainStr, String subStr) {
        //1.判断主串和部分串的大小
        if (mainStr.length() >= subStr.length()) {
            int index = 0;
            int count = 0;
            //2.在主串中取出子串下标，并将新的下标赋值给主串，统计量加1
//            while ((index = mainStr.indexOf(subStr) )!= -1){
//                count++;
//                mainStr = mainStr.substring(index + subStr.length());
//            }
            //改进
            while ((index = mainStr.indexOf(subStr, index)) != -1) {
                index += subStr.length();
                count++;
            }
            return count;
        } else {
            return 0;
        }
    }

    @Test
    public void countTest() {
        String str1 = "cdabkkcadkabkebfkabkskab";
        int count = count(str1, "ab");
        System.out.println(count);
    }


    /**
     * 4.获取两个字符串中最大相同子串。比如：
     * str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"//10
     * 提示：将短的那个串进行长度依次递减的子串与较长的串比较。
     */
    //只存在一个子串的情况
    public String getMaxSameSubString(String str1, String str2) {
        //1.判断两个字串的大小
        if (str1 != null && str2 != null) {
            String maxStr = (str1.length() > str2.length()) ? str1 : str2;
            String minStr = (str1.length() > str2.length()) ? str2 : str1;

            int len = minStr.length();
            //2.用小的依次去比对大的子串
            for (int i = 0; i < len; i++) {//这层for循环用来确定需要比对的字符次数
                for (int x = 0, y = len - i; y <= len; x++, y++) {
                    if (maxStr.contains(minStr.substring(x, y))) {
                        return minStr.substring(x, y);
                    }
                }

            }
        }
        return null;
    }

    //存在多个相同子串的情况
    // 此时先返回String[]，后面可以用集合中的ArrayList替换，较方便
    public String [] getMaxSameSubStrings(String str1, String str2) {
        //1.先比较出两个子串的大小
        if (str1 != null && str2 != null) {
            StringBuffer stringBuffer = new StringBuffer();
            String maxStr = (str1.length() > str2.length()) ? str1 : str2;
            String minStr = (str1.length() > str2.length()) ? str2 : str1;
            //2.用小的去依次匹配大的
            int len = minStr.length();
            for (int i = 0; i < len; i++) {
                for (int x = 0, y = len - i; y <= len; x++,y++ ){
                    String subString = minStr.substring(x,y);
                    //3.取出匹配到的子串
                    if (maxStr.contains(subString)){
                        stringBuffer.append(subString+",");
                    }
                }
//                System.out.println(stringBuffer);
                if (stringBuffer.length() != 0){
                    break;
                }
            }

            String [] split = stringBuffer.toString().replaceAll(",$","").split("\\,");
            return split;
        }
        return null;
    }

    @Test
    public void getMaxSameSubStringTest() {
        String str1 = "abcwerthelloyuiodef";
        String str2 = "cvabchellobnmdef";
        String maxSameSubString = getMaxSameSubString(str1, str2);
        System.out.println(maxSameSubString);

        String[] maxSameSubStrings = getMaxSameSubStrings(str1, str2);
        System.out.println(Arrays.toString(maxSameSubStrings));
    }


    /**
     * 5.对字符串中字符进行自然顺序排序。"abcwerthelloyuiodef"
     * 提示：
     * 1）字符串变成字符数组。
     * 2）对数组排序，选择，冒泡，Arrays.sort(str.toCharArray());
     * 3）将排序后的数组变成字符串。
     */
    @Test
    public void charTest() {
        String str1 = "hello java";
        char[] charArray = str1.toCharArray();

        Arrays.sort(charArray);

        String str2 = new String(charArray);
        System.out.println(str2);
    }
}
