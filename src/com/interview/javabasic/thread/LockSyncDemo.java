package com.interview.javabasic.thread;

/**
 * @author jason.yang
 * @Description
 * @Date 2021-04-19 18:29
 */
public class LockSyncDemo {

    static Object object = new Object();

    public static void m1() {
        synchronized (object) {
            System.out.println("hello synchronized code block");
        }
    }

    public static void main(String[] args) {
        m1();
    }



}