package com.interview.javabasic.mutithread.jdkutil;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author jason.yang
 * @Description 集齐7颗龙珠就可以召唤神龙了
 * 只有当七颗龙珠全部收集完成，才会执行召唤神龙的任务，这个就是栅栏的真正作用
 * @Date 2022-08-04 16:57
 */
public class CyclicBarrierExample {


    public static void main(String[] args) throws InterruptedException {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, new CallDragonTask());
        repeateUse(cyclicBarrier);
        Thread.sleep(100);
        repeateUse(cyclicBarrier);

    }

    private static void repeateUse(CyclicBarrier cyclicBarrier) {
        for (int i = 1; i <= 7; i++) {
            final int tempVal = i;
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName()+"\t收集到了第" + tempVal +"颗龙珠");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, "龙珠"+i).start();
        }
    }

}