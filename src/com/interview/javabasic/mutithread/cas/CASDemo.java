package com.interview.javabasic.mutithread.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jason.yang
 * @Description cas操作代码
 * @Date 2021-04-15 14:29
 */
public class CASDemo {

    public static void main(String[] args) {
        //创建一个原子类
        AtomicInteger atomicInteger = new AtomicInteger(700);
        atomicInteger.getAndIncrement();

        System.out.println(atomicInteger.compareAndSet(700, 100)+","+atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(100, 2022)+","+atomicInteger.get());

    }

}