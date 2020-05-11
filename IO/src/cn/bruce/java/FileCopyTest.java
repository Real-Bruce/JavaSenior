package cn.bruce.java;

import org.junit.Test;

import java.io.*;

/**
 * @author bruce
 * @project_name JavaSenior
 * @package_name cn.bruce.java
 * @create 2020-05-04 14:51
 */
public class FileCopyTest {

    @Test
    public void test(){
        long start = System.currentTimeMillis();

        String srcFile ="F:\\Users\\Administrator\\Desktop\\test.avi";
        String destFile = "F:\\Users\\Administrator\\Desktop\\test1.avi";

        copyFile1(srcFile,destFile);

        long end = System.currentTimeMillis();
        System.out.println("复制所用时间为："+(end - start));
    }

    /**
     * 通过FileInputSteam和FileOutputSteam方法实现图片的复制操作
     * @param srcFile
     * @param destFile
     */
    public void copyFile(String srcFile,String destFile){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(new File(srcFile));
            fos = new FileOutputStream(new File(destFile));

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    /**
     * 通过缓冲流的方式复制文件
     * @param srcFile
     * @param destFile
     */
    public void copyFile1(String srcFile,String destFile){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(new File(srcFile)));
            bos = new BufferedOutputStream(new FileOutputStream(new File(destFile)));

            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null){

                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
