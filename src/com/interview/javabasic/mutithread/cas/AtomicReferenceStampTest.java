package com.interview.javabasic.mutithread.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jason.yang
 * @Description 解决CAS中产生的ABA问题
 * @Date 2021-04-15 15:42
 */
public class AtomicReferenceStampTest {

    //原子引用包装器类型比较并交换的时候，底层还是维护的是一个固定大小0~127数组内的比较并替换，超过时，底层内存偏移量可能发生了变化    缓存池概率引入
    private static AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(-128, 1);
    Lock lock = new ReentrantLock();
    public static void main(String[] args) {
        new Thread(() -> {
            int stamp = stampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "第一次拿到的值为：\t" + stampedReference.getReference() + "," + Thread.currentThread().getName() + "第一次得到的版本号为：\t" + stamp);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(stampedReference.compareAndSet(-128, 100, stampedReference.getStamp(), stampedReference.getStamp() + 1));
            System.out.println(Thread.currentThread().getName() + "第二次拿到的值为：\t" + stampedReference.getReference() + "," + Thread.currentThread().getName() + "第二次得到的版本号为：\t" + stampedReference.getStamp());
            System.out.println(stampedReference.compareAndSet(100, -128, stampedReference.getStamp(), stampedReference.getStamp() + 1));
            System.out.println(Thread.currentThread().getName() + "第三次拿到的值为：\t" + stampedReference.getReference() + "," + Thread.currentThread().getName() + "第三次得到的版本号为：\t" + stampedReference.getStamp());
        }, "T1").start();

        System.out.println("-------------------------------------");
        new Thread(() -> {
            int stamp = stampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "第一次拿到的值为：\t" + stampedReference.getReference() + "," + Thread.currentThread().getName() + "第一次得到的版本号为：\t" + stamp);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(stampedReference.compareAndSet(5,100,stamp,stamp+1));
            System.out.println("当前最新版本号的值时：" + stampedReference.getStamp());
        }, "T2").start();

    }

}