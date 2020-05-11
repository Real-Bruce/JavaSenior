package cn.bruce.java1;

import org.junit.Test;

import java.io.*;

/**
 * @author bruce
 * @project_name JavaSenior
 * @package_name cn.bruce.java1
 * @create 2020-05-04 21:12
 */
public class ObjectInputOutSteamTest {
    /**
     * 序列化过程：将内存中的java对象保存到磁盘中或通过网络传输出去
     * 使用ObjectOutputStream实现
     */
    @Test
    public void test1() {
        ObjectOutputStream oos = null;
        try {
            //1.
            oos = new ObjectOutputStream(new FileOutputStream("data.dat"));

            //2.
            oos.writeObject(new String("我爱你"));
            oos.flush();

            oos.writeObject(new Person("Bruce", 23));
            oos.flush();

            oos.writeObject(new Person("Zhang", 23, 1001, new Account(100)));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.
            if (oos != null) {

                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    反序列化：将磁盘文件中的对象还原为内存中的一个java对象
    使用ObjectInputStream来实现
     */
    @Test
    public void test2() {
        ObjectInputStream ois = null;
        try {
            //1.
            ois = new ObjectInputStream(new FileInputStream("data.dat"));

            //2.
            Object object = ois.readObject();
            String str = (String)object;

            Person p1 = (Person) ois.readObject();
            Person p2 = (Person) ois.readObject();

            System.out.println(str);
            System.out.println(p1);
            System.out.println(p2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //3.
            if (ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
