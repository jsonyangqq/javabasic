package com.interview.javabasic.mutithread.jdkutil;

import java.util.concurrent.CountDownLatch;

/**
 * @author jason.yang
 * @Description
 * @Date 2022-08-04 17:19
 */
public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(7);
        repeateUse(countDownLatch);
        Thread.sleep(100);
        repeateUse(countDownLatch);

    }

    private static void repeateUse(CountDownLatch countDownLatch) {
        for (int i = 1; i <= 7; i++) {
                final int tempVal = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t收集到了第" + tempVal +"颗龙珠");
                countDownLatch.countDown();
            }, "龙珠" + i).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("七颗龙珠已经集器，唤出神龙！");
    }

}