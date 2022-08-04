package com.interview.javabasic.mutithread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jason.yang
 * @Description volatile验证
 * 1.可见性验证
 * @Date 2021-04-13 8:29
 */

class MyData {
    public volatile int i=0;

    public AtomicInteger atomicInteger = new AtomicInteger();

    public void changed() {
        this.i = 60;
    }


    public void increment() {
        i++;
    }

    /**
     * 原子操作自增
     */
    public void atomicIncrement() {
        atomicInteger.getAndIncrement();
    }

}

public class VolatileDemo {

    public static void main(String[] args) {
//        visibilityProblem();
          atomicityProblem();
    }

    //原子性问题验证
    private static void atomicityProblem() {
        MyData myData = new MyData();
        for(int i=1; i<=20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    myData.increment();
                    myData.atomicIncrement();
                }
            }, String.valueOf(i)).start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "variable i increment result " + myData.i);
        System.out.println(Thread.currentThread().getName() + "variable atomicInteger increment result " + myData.atomicInteger);
    }


    //可见性问题解决
    private static void visibilityProblem() {
        MyData myData = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "Thread change before println result " + myData.i);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.changed();
            System.out.println(Thread.currentThread().getName() + "Thread change after println result " + myData.i);
        }, "AAA").start();


        while (myData.i == 0) {

        }

        System.out.println("main thread input out " + myData.i);
    }

}