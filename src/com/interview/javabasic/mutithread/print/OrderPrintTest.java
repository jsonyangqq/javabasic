package com.interview.javabasic.mutithread.print;

import java.util.concurrent.TimeUnit;

/**
 * @author jason.yang
 * @Description 多线程顺序打印ABC，打印n次
 * 首先我们可以想到的是如果要保证多线程环境下的顺序执行，可以考虑到使用join实现
 * 1.1 如果我们不用考虑线程重复创建消费等情况的话
 * @Date 2021-04-17 9:11
 */
public class OrderPrintTest {

    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            try {
                Thread t1 = new Thread(new ExexcutePrintA(),"T1");
                Thread t2 = new Thread(new ExexcutePrintB(),"T2");
                Thread t3 = new Thread(new ExexcutePrintC(),"T3");
                t1.start();
                t1.join();
                t2.start();
                t2.join();
                t3.start();
                t3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
        }

    }

}

class ExexcutePrintA implements Runnable {

    @Override
    public void run() {
        System.out.print(Thread.currentThread().getName() + " -> " + "A"+"\t");
    }

}

class ExexcutePrintB implements Runnable {

    @Override
    public void run() {
        System.out.print(Thread.currentThread().getName() + " -> " + "B"+"\t");
    }

}

class ExexcutePrintC implements Runnable {

    @Override
    public void run() {
        System.out.print(Thread.currentThread().getName() + " -> " + "C"+"\t");
    }

}