package com.interview.nativacode;

import com.google.common.collect.Lists;

import java.util.ArrayList;

/**
 * @author jason.yang
 * @Description
 * @Date 2022-03-24 20:52
 */
public class ThreadTest {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            System.out.println("线程A执行了");
        }, "线程A");

        Thread t2 = new Thread(() -> {
            System.out.println("线程B执行了");
        },"线程B");

        t1.start();
        t2.start();




    }

}