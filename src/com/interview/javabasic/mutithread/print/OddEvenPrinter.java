package com.interview.javabasic.mutithread.print;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jason.yang
 * @Description 两个线程交替打印 0~100 的奇偶数
 * @Date 2021-04-18 16:26
 */
public class OddEvenPrinter {

    private int state;
    private int count;

    public OddEvenPrinter(int count) {
        this.count = count;
    }

    private static final Lock lock = new ReentrantLock();


    public static void main(String[] args) {
        OddEvenPrinter oddEvenPrinter = new OddEvenPrinter(50);
        new Thread(() -> {
            oddEvenPrinter.printOddEven(0,"T1");
        }, "T1").start();
        new Thread(() -> {
            oddEvenPrinter.printOddEven(1,"T2");
        }, "T2").start();
    }

    private void printOddEven(int targetThread, String threadName) {
        for (int i = 0; i < count;) {
            lock.lock();
            if(state % 2 == targetThread) {
                System.out.println("线程:" + threadName + "当前打印："+state);
                i++;
                state++;
            }
            lock.unlock();
        }
    }

}