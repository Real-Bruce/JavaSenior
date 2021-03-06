package com.bruce.java;

/**
 * @author bruce
 * @project_name JavaSenior
 * @package_name com.bruce.java
 * @create 2020-04-14 20:56
 */
public class Ticket4 extends Thread {
    private static int tick = 100;
    private static boolean isFlag = true;

    @Override
    public void run() {
        while (isFlag) {
            show();

        }
    }

    public static synchronized void show() {//同步show方法,需要加static确保同步方法只执行依次
        if (tick > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "号窗口买票，票号为：" + tick--);
        } else {
            isFlag = false;
        }
    }
}

class TicketTest4 {
    public static void main(String[] args) {
        Ticket4 ticket = new Ticket4();

        Thread thread1 = new Thread(ticket);
        Thread thread2 = new Thread(ticket);
        Thread thread3 = new Thread(ticket);

        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
