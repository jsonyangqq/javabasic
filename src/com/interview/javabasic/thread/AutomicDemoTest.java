package com.interview.javabasic.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jason.yang
 * @Description 重入锁ReentrantLock使用
 * @Date 2021-04-19 16:29
 */
public class AutomicDemoTest {

    static Lock lock = new ReentrantLock();
    private static int count = 0;

    public static void incr() {
        try{
            lock.lock();
            count++;
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                AutomicDemoTest.incr();
            }).start();
        }
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("reslult:"+count);
    }

}