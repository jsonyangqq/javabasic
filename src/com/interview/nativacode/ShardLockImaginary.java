package com.interview.nativacode;

import java.util.concurrent.TimeUnit;

/**
 * @author jason.yang
 * @Description 共享锁突发奇想
 * @Date 2022-04-09 20:15
 */
public class ShardLockImaginary {

    private Object mointerObject = new Object();

    public void m1() {
        synchronized (mointerObject) {
            System.out.println("执行了m1方法");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void m2() {
        synchronized (mointerObject) {
            System.out.println("执行了m2方法");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ShardLockImaginary imaginary = new ShardLockImaginary();
        new Thread(()-> {
            imaginary.m1();
        },"Thread1").start();

        new Thread(()-> {
            imaginary.m2();
        },"Thread2").start();
    }

}