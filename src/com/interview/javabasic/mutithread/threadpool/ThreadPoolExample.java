package com.interview.javabasic.mutithread.threadpool;

import java.sql.Time;
import java.util.concurrent.*;

/**
 * @author jason.yang
 * @Description 线程池demo
 * @Date 2022-04-17 16:47
 */
public class ThreadPoolExample {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(()-> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("执行完了！");

    }

}