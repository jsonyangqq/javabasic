package com.interview.nativacode;

import com.mysql.jdbc.TimeUtil;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jason.yang
 * @Description
 * @Date 2022-03-24 20:28
 */
public class AqsDemo {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Thread A Come in");
            } finally {
                lock.unlock();
            }
        }, "Thread-A");

        Thread t2 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Thread B Come in");
            } finally {
                lock.unlock();
            }
        }, "Thread-B");

        Thread t3 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Thread C Come in");
            } finally {
                lock.unlock();
            }
        }, "Thread-C");

        t1.start();
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        t3.start();

    }

}