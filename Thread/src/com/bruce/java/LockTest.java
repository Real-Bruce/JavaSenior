package com.bruce.java;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author bruce
 * @project_name JavaSenior
 * @package_name com.bruce.java
 * @create 2020-04-14 22:26
 */
class Windows implements Runnable {
    private int tick = 100;
    //1.创建ReentrantLock对象
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {

            try {
                lock.lock();//2.上锁

                if (tick > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "号窗口买票，票号为：" + tick--);
                } else {
                    break;
                }
            }finally {
                //3.解锁
                lock.unlock();
            }


        }
    }
}

public class LockTest {
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
