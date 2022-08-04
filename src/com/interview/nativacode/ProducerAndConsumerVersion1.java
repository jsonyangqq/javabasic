package com.interview.nativacode;

/**
 * @author jason.yang
 * @Description wait和notify里面的一个生产者对应一个消费者
 * @Date 2022-04-09 16:20
 */
public class ProducerAndConsumerVersion1 {

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
                mointerObject.notify(); //唤醒消费者线程
                isProduced = true;
            }
        }
    }

    /**
     * 消费数据的方法
     */
    public void consumer() {
        synchronized (mointerObject) {
            if (isProduced) {
                System.out.println(Thread.currentThread().getName() + "消费者线程消费数据：" + count);
                mointerObject.notify();
                isProduced = false;
            } else {
                try {
                    mointerObject.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProducerAndConsumerVersion1 producerAndConsumerVersion1 = new ProducerAndConsumerVersion1();
        new Thread(()-> {
            while (true) {
                producerAndConsumerVersion1.producer();
            }
        },"P1").start();

        new Thread(()-> {
            while (true) {
                producerAndConsumerVersion1.consumer();
            }
        },"C1").start();


    }



}