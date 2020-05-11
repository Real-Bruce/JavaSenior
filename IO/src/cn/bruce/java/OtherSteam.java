package cn.bruce.java;

import org.junit.Test;

import java.io.*;

/**
 * @author bruce
 * @project_name JavaSenior
 * @package_name cn.bruce.java
 * @create 2020-05-04 16:42
 */
public class OtherSteam {
    /**
     * 1.标准输入输出流
     */
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);

            while (true) {
                System.out.println("请输入字符串：");
                String data = br.readLine();
                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
                    System.out.println("程序结束！");
                    break;
                }
                String upperCase = data.toUpperCase();
                System.out.println(upperCase);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {

                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 2. 打印流：PrintStream 和PrintWriter
     * 2.1 提供了一系列重载的print() 和 println()
     * 2.2 练习：
     */
    @Test
    public void test1() {
        FileOutputStream fos = null;
        PrintStream ps = null;
        try {
            fos = new FileOutputStream(new File("E:\\test\\test1\\text.txt"));
            // 创建打印输出流,设置为自动刷新模式(写入换行符或字节 '\n' 时都会刷新输出缓冲区)
            ps = new PrintStream(fos, true);
            if (ps != null) {// 把标准输出流(控制台输出)改成文件
                System.setOut(ps);
            }

            for (int i = 0; i <= 255; i++) {// 输出ASCII字符
                System.out.print((char) i);
                if (i % 50 == 0) {//每50个换行
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {

                ps.close();
            }
            if (fos != null) {

                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 3. 数据流
     *     3.1 DataInputStream 和 DataOutputStream
     *     3.2 作用：用于读取或写出基本数据类型的变量或字符串
     *
     *     练习：将内存中的字符串、基本数据类型的变量写出到文件中
     */
    @Test
    public void test3(){
        //1.造对象、造流
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("data.txt"));
            //数据输出
            dos.writeUTF("Bruce");
            dos.flush();//刷新操作，将内存的数据写入到文件
            dos.writeInt(23);
            dos.flush();
            dos.writeBoolean(true);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.关闭流
            if (dos != null){
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test4(){
        DataInputStream dis = null;
        try {
            //1.造对象、造流
            dis = new DataInputStream(new FileInputStream("data.txt"));
            //2.从文件读入数据
            String name = dis.readUTF();
            int age = dis.readInt();
            boolean isMale = dis.readBoolean();

            System.out.println("name:"+name);
            System.out.println("age:"+age);
            System.out.println("isMale:"+isMale);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.关闭流
            if (dis != null){

                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
