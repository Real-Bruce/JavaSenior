package cn.bruce.exer;

import org.junit.Test;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
 *
 * @author bruce
 * @project_name JavaSenior
 * @package_name cn.bruce.exer
 * @create 2020-05-04 13:54
 */
public class FindJPGFileTest {
    @Test
    public void test1() {
        File file = new File("E:\\test\\test1");
        String[] fileNames = file.list();
        for (String fileName : fileNames) {
            if (fileName.endsWith(".jpg")) {
                System.out.println(fileName);
            }
        }
    }

    @Test
    public void test2() {
        File file = new File("E:\test\test1");
        File[] listFiles = file.listFiles();
        for (File f :
                listFiles) {
            if (f.getName().endsWith(".jpg")) {
                System.out.println(f);
            }
        }
    }

    /*
     * File类提供了两个文件过滤器方法
     * public String[] list(FilenameFilter filter)
     * public File[] listFiles(FileFilter filter)
     */
    @Test
    public void test3(){
        File srcFile = new File("E:\\test\\test1");
        File[] files = srcFile.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".jpg");
            }
        });
        for (File file :
                files) {
            System.out.println(file.getAbsolutePath());
        }
    }
}
