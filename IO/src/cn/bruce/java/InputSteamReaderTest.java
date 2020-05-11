package cn.bruce.java;

import org.junit.Test;

import java.io.*;

/**
 * @author bruce
 * @project_name JavaSenior
 * @package_name cn.bruce.java
 * @create 2020-05-04 16:43
 */
public class InputSteamReaderTest {
    @Test
    public void test1() {
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            //1.造文件、造流
            File file1 = new File("dbcp.txt");
            File file2 = new File("dbcp_gbk.txt");

            FileInputStream fis = new FileInputStream(file1);
            FileOutputStream fos = new FileOutputStream(file2);

            isr = new InputStreamReader(fis, "utf-8");
            osw = new OutputStreamWriter(fos, "gbk");

            //2.读写过程
            char[] cbuf = new char[20];
            int len;
            while ((len = isr.read(cbuf)) != -1){
                osw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.关流
            if (isr != null){

                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (osw != null){
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }
}
