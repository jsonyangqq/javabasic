package com.interview.nativacode;

import java.util.stream.Stream;

/**
 * @author jason.yang
 * @Description 多生产者对应对消费者(方式二实现)
 * 问题一：多生产者和多消费，如果采用wait()和notify的方式会出现线程假死问题，原因是？如果解决呢？
 * 问题二：为啥多生产者和多消费者进行判断是否生产或者消费数据时，要用while循环？
 * @Date 2022-04-09 16:39
 */
public class ProducerAndConsumerVersion3 {

    private static boolean isProduced = false;

    private Object mointerObject = new Object();

    public int count=0;

    /**
     * 生产者线程生产数据的方法
     */
    public void producer() {
        synchronized (mointerObject) {
            if (isProduced) {
                try {
                    mointerObject.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                count++;
                System.out.println(Thread.currentThread().getName() + "生产者线程生产数据：" + count);
                mointerObject.notifyAll(); //唤醒消费者线程
                isProduced = true;
            }
        }
    }

    /**
     * 消费数据的方法
     */
    public void consumer() {
        synchronized (mointerObject) {
            if (!isProduced) {
                try {
                    mointerObject.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + "消费者线程消费数据：" + count);
                mointerObject.notifyAll(); //C2唤醒阻塞的P2
                isProduced = false;
            }
        }
    }

    public static void main(String[] args) {
        ProducerAndConsumerVersion3 pV2 = new ProducerAndConsumerVersion3();
        Stream.of("P1","P2","P3").forEach(p -> {
            new Thread(()-> {
                while (true) {
                    pV2.producer();
                }
            },p).start();
        });

        Stream.of("C1","C2","C3","C4","C5").forEach(p -> {
            new Thread(()-> {
                while (true) {
                    pV2.consumer();
                }
            },p).start();
        });


    }

}