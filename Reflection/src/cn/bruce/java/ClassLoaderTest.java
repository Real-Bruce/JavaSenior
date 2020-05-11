package cn.bruce.java;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author bruce
 * @project_name JavaSenior
 * @package_name cn.bruce.java
 * @create 2020-05-06 14:30
 */
public class ClassLoaderTest {
    @Test
    public void test1() {
        //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        //调用系统类加载器的getParent()：获取扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);
        //调用扩展类加载器的getParent()：无法获取引导类加载器
        //引导类加载器主要负责加载java的核心类库，无法加载自定义类的。
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);

        ClassLoader classLoader3 = String.class.getClassLoader();
        System.out.println(classLoader3);
    }

    /*
    Properties：用来读取配置文件。
     */
    @Test
    public void test3(){
        Properties pros = new Properties();
//        //读取配置文件的方式一：
//        //此时的文件默认在当前的module下。
//        FileInputStream fis = null;
//        try {
//            fis = new FileInputStream("jdbc1.properties");
//            pros.load(fis);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (fis != null) {
//                try {
//                    fis.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

        //读取配置文件的方式二：使用ClassLoader
        //配置文件默认识别为：当前module的src下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        try {
            pros.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }


        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.println("user = " + user + " password =" + password);
    }

}
