package com.interview.javabasic.mutithread.basic;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @author jason.yang
 * @Description join应用场景加深理解
 * @Date 2022-08-05 23:16
 */
public class ThreadJoin {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            IntStream.range(1,1000)
                    .forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));
        });

        Thread t2 = new Thread(() -> {
            IntStream.range(1,1000)
                    .forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));
        });

        // 我们可以让t1和t2并发执行，也可以让它们顺序执行，取决于join防止位置
        t1.start();
        t1.join();
        t2.start();
        t2.join();

        Optional.of("All of tasks finish done.").ifPresent(System.out::println);

        IntStream.range(1,1000)
                .forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));

    }



}