package com.interview.javabasic.mutithread.use;

import java.util.concurrent.TimeUnit;

/**
 * @author jason.yang
 * @Description synchronized使用
 * @Date 2021-04-16 10:05
 */
public class SynchronizedTest {

    private static Object LOCK = new Object();

    public static void main(String[] args) {

        Runnable runnable = () -> {
            synchronized (LOCK) {
                try {
                    TimeUnit.SECONDS.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        t1.start();
        t2.start();
        t3.start();

    }

}