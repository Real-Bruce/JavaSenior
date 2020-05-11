package cn.bruce.java;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author bruce
 * @project_name JavaSenior
 * @package_name cn.bruce.java
 * @create 2020-05-04 09:48
 */
public class FileTest {
    @Test
    public void test1() {
        //构造器1
        File file1 = new File("hello.txt");
        File file2 = new File("E:\\workspace_idea\\JavaSenic\\IO\\hello.txt");
        System.out.println(file1);
        System.out.println(file2);

        //构造器2
        File file3 = new File("E:\\workspace_idea\\JavaSenior", "hello.txt");
        System.out.println(file3);

        //构造器3
        File file4 = new File(file3, "hi.txt");
        System.out.println(file4);
    }

    /**
     * public String getAbsolutePath()：获取绝对路径
     * public String getPath() ：获取路径
     * public String getName() ：获取名称
     * public String getParent()：获取上层文件目录路径。若无，返回null
     * public long length() ：获取文件长度（即：字节数）。不能获取目录的长度。
     * public long lastModified() ：获取最后一次的修改时间，毫秒值
     * <p>
     * 如下的两个方法适用于文件目录：
     * public String[] list() ：获取指定目录下的所有文件或者文件目录的名称数组
     * public File[] listFiles() ：获取指定目录下的所有文件或者文件目录的File数组
     */
    @Test
    public void test2() {
        File file1 = new File("E:\\workspace_idea\\JavaSenior\\hello.txt");
        File file2 = new File("hello.txt");

        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));

        System.out.println("****************");

        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(new Date(file2.lastModified()));

    }

    @Test
    public void test3() {
        File file = new File("E:\\WorkSpace\\workspace_idea\\JavaSenior");

        String[] list = file.list();
        for (String str :
                list) {
            System.out.println(str);
        }

        System.out.println("***********");

        File[] files = file.listFiles();
        for (File f :
                files) {
            System.out.println(f);
        }
    }

    /**
     * public boolean renameTo(File dest):把文件重命名为指定的文件路径
     * 比如：file1.renameTo(file2)为例：
     * 要想保证返回true,需要file1在硬盘中是存在的，且file2不能在硬盘中存在。
     */

    @Test
    public void test4() {
        File file1 = new File("hello.txt");
        File file2 = new File("E:\\WorkSpace\\workspace_idea\\JavaSenior");
        boolean renameTo = file1.renameTo(file2);
        System.out.println(renameTo);
    }

    /**
     * public boolean isDirectory()：判断是否是文件目录
     * public boolean isFile() ：判断是否是文件
     * public boolean exists() ：判断是否存在
     * public boolean canRead() ：判断是否可读
     * public boolean canWrite() ：判断是否可写
     * public boolean isHidden() ：判断是否隐藏
     */

    @Test
    public void test5() {
        File file = new File("hello.txt");
        file = new File("E:\\WorkSpace");
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.isHidden());
    }

    /**
     * 创建硬盘中对应的文件或文件目录
     * public boolean createNewFile() ：创建文件。若文件存在，则不创建，返回false
     * public boolean mkdir() ：创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建。
     * public boolean mkdirs() ：创建文件目录。如果此文件目录存在，就不创建了。如果上层文件目录不存在，一并创建
     * <p>
     * 删除磁盘中的文件或文件目录
     * public boolean delete()：删除文件或者文件夹
     * 删除注意事项：Java中的删除不走回收站。
     */

    @Test
    public void test6() throws IOException {
//        //创建文件操作
//        File file = new File("hi.txt");
//        if (!file.exists()){
//            //创建文件
//            file.createNewFile();
//            System.out.println("创建成功");
//        }else {
//            file.delete();
//            System.out.println("删除成功");
//        }

        //创建文件目录操作
        File file1 = new File("E:\\test");
        boolean mkdir = file1.mkdir();
        if (mkdir){
            System.out.println("创建成功1");
        }else {
            System.out.println("创建失败1");
        }

        System.out.println();
        //创建多层文件目录
        File file2 = new File("E:\\test\\test1\\test2");
        boolean mkdir2 = file2.mkdir();
        if (mkdir2){
            System.out.println("创建成功2");
        }else {
            System.out.println("创建失败2");
        }

        System.out.println();
        //创建多层文件目录
        boolean mkdirs = file2.mkdirs();
        if (mkdirs){
            System.out.println("创建成功3");
        }else {
            System.out.println("创建失败3");
        }
        //要想删除成功，io4文件目录下不能有子目录或文件
        File file3 = new File("E:\\test");
        System.out.println(file3.delete());
        file3 = new File("E:\\test\\test1\\test2");
        System.out.println(file3.delete());
    }



}
