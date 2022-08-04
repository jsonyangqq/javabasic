package com.interview.javabasic.mutithread.print;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jason.yang
 * @Description 多线程顺序打印ABC
 * 三个线程分别打印 A，B，C，要求这三个线程一起运行，打印 n 次，输出形如“ABCABCABC....”的字符串
 * @Date 2021-04-17 9:48
 */
public class PrintABCUsingLock {

    private static final Lock lock = new ReentrantLock();
    private int printCount;
    private static int state;

    public PrintABCUsingLock(Integer printCount) {
        this.printCount = printCount;
    }

    public static void main(String[] args) {
        PrintABCUsingLock printABCUsingLock = new PrintABCUsingLock(3);
        new Thread(() -> {
            printABCUsingLock.printAssignThreadVal(0,"A");
        }, "T1").start();
        new Thread(() -> {
            printABCUsingLock.printAssignThreadVal(1,"B");
        }, "T2").start();
        new Thread(() -> {
            printABCUsingLock.printAssignThreadVal(2,"C");
        }, "T3").start();



    }

    /**
     * 打印对应线程所对应的值
     * @param number 线程编号
     * @param realContent 真实所需打印的内容
     */
    private void printAssignThreadVal(Integer number, String realContent) {
        for (int i = 0; i < printCount;) {
            lock.lock();
            if(state % 3 == number) {
                i++;
                state++;
                System.out.print(realContent);
            }
            lock.unlock();

        }
    }



}