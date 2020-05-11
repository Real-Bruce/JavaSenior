package cn.bruce.exer;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author bruce
 * @project_name JavaSenior
 * @package_name cn.bruce.exer
 * @create 2020-05-04 10:36
 */
public class FileDemo {
@Test
    public void test1() throws IOException {
    File file = new File("E:\\test\\test1\\hello.txt");
    File destFile = new File(file.getParent(), "haha.txt");
    boolean newFile = destFile.createNewFile();
    if (newFile){
        System.out.println("创建成功");
    }else{
        System.out.println("创建失败");
    }
}

}
