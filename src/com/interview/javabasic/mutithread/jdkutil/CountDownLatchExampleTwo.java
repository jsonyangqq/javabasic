package com.interview.javabasic.mutithread.jdkutil;

import java.util.concurrent.CountDownLatch;

/**
 * @author jason.yang
 * @Description  实现main线程等待多个线程执行完成才执行后续操作
 * @Date 2022-08-05 0:15
 */
public class CountDownLatchExampleTwo {

    private static CountDownLatch countDownLatch = new CountDownLatch(3);

    static class Thread1 extends Thread {

        public Thread1(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + "工人工作完成");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        }
    }

    static class Thread2 extends Thread {

        public Thread2(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + "工人工作完成");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        }
    }

    static class Thread3 extends Thread {

        public Thread3(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + "工人工作完成");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread1("T1");
        t1.start();

        Thread t2 = new Thread2("T2");
        t2.start();

        Thread t3 = new Thread3("T3");
        t3.start();
        countDownLatch.await();

        System.out.println("三个工人都工作完成，main改发工资了！");

    }


}