package cn.bruce.exer;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 练习3:获取文本上字符出现的次数,把数据写入文件
 * *
 * * 思路：
 * * 1.遍历文本每一个字符
 * * 2.字符出现的次数存在Map中
 * *
 * * Map<Character,Integer> map = new HashMap<Character,Integer>();
 * * map.put('a',18);
 * * map.put('你',2);
 * *
 * * 3.把map中的数据写入文件
 *
 * @author bruce
 * @project_name JavaSenior
 * @package_name cn.bruce.exer
 * @create 2020-05-04 16:19
 */
public class WordCount {
    @Test
    public void test1() {
        File file = new File("dbcp.txt");
        wordCount(file);

    }

    public void wordCount (File file){
        FileReader fr = null;
        BufferedWriter bw = null;
        try {
            //1.创建Map集合
            HashMap<Character, Integer> map = new HashMap<>();
            //2.遍历每个字符，将每个字符出现的次数存放到map中
            fr = new FileReader(file);
            int cout = 0;
            while ((cout = fr.read()) != -1){
                //将int还原为char
                char ch = (char)cout;
                //判断char是否为首次出现
                if (map.get(ch) == null){
                    map.put(ch,1);
                }else {
                    map.put(ch,map.get(ch)+1);
                }
            }
            //3.将map中的数据存放到count.txt
            //3.1创建Writer流
            bw = new BufferedWriter(new FileWriter(new File("wordcount.txt")));
            //3.2遍历map集合，再写出数据
            Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
            for (Map.Entry<Character, Integer> entry :
                    entrySet) {
                switch (entry.getKey()){
                    case ' ':
                        bw.write("空格="+entry.getValue());
                        break;
                    case '\t':
                        bw.write("制表符="+entry.getValue());
                        break;
                    case '\r':
                        bw.write("回车="+entry.getValue());
                        break;
                    case '\n':
                        bw.write("换行="+entry.getValue());
                        break;
                    default:
                        bw.write(entry.getKey()+"="+entry.getValue());
                        break;
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关流
            if (bw != null){

                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fr != null){

                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
