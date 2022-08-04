package com.interview.javabasic.mutithread.print;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jason.yang
 * @Description 锁绑定多个condition条件
 * 实现A->B->C三个线程启动，A打印5次，B打印10次，C打印15次，一共打印10轮
 * @Date 2021-05-15 21:42
 */

public class SynMultiConditionLockDemo {

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                sharedResource.print5();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                sharedResource.print10();
            }
        }, "B").start();new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                sharedResource.print15();
            }
        }, "C").start();

    }

}

class SharedResource {

    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5() {
        lock.lock();
        try {
            //判断
            while (number != 1) {
                c1.await();
            }
            //执行语句
            for (int i = 1; i <=5; i++) {
                System.out.println(Thread.currentThread().getName()+"\t");
            }
            //修改标记位置
            number = 2;
            //释放锁
            c2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            //判断
            while (number != 2) {
                c2.await();
            }
            //执行语句
            for (int i = 1; i <=10; i++) {
                System.out.println(Thread.currentThread().getName()+"\t");
            }
            //修改标记位置
            number = 3;
            //释放锁
            c3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try {
            //判断
            while (number != 3) {
                c3.await();
            }
            //执行语句
            for (int i = 1; i <=15; i++) {
                System.out.println(Thread.currentThread().getName()+"\t");
            }
            //修改标记位置
            number = 1;
            //释放锁
            c1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


}