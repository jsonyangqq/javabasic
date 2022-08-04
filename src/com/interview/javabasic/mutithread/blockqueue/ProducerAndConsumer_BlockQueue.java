package com.interview.javabasic.mutithread.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jason.yang
 * @Description 使用生产者消费者实现阻塞队列
 * 模拟生产者生产一个消息，消费者立马要消费一个消息，main线程控制全局停止
 * @Date 2021-05-15 23:09
 */
public class ProducerAndConsumer_BlockQueue {

    public static void main(String[] args) {

        MyResource myResource = new MyResource(new ArrayBlockingQueue(3));
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "生产者线程启动!");
            try {
                myResource.producerMessage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Producer").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "消费者线程启动!");
            System.out.println();
            System.out.println();
            try {
                myResource.consumerMessage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Consumer").start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("5秒钟时间到，main线程叫停了，程序退出！");
        myResource.stop();

    }

}

class MyResource {

    private volatile boolean FLAG = true;

    private BlockingQueue<String> blockingQueue = null;

    AtomicInteger atomicInteger = new AtomicInteger();

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }


    //生产消息的方法
    public void producerMessage() throws Exception {
        String data = null;
        boolean retunValue;
        while (FLAG) {
            data = atomicInteger.incrementAndGet()+"";
            retunValue = blockingQueue.offer(data, 2L,TimeUnit.SECONDS);
            if(retunValue) {
                System.out.println(Thread.currentThread().getName() + "插入队列"+data + "成功");
            }else {
                System.out.println(Thread.currentThread().getName() + "插入队列"+data + "失败");
            }
            //1秒钟生产一个
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("main线程叫停了，生产者退出！");
    }

    //消费消息的方法
    public void consumerMessage() throws Exception {
        String data = null;
        while (FLAG) {
            data = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if(null == data || "".equals(data)) {
                FLAG = false;
                System.out.println("消费者2秒没有取到值，消费退出");
                System.out.println();
                System.out.println();
                return;
            }
            System.out.println(Thread.currentThread().getName() + "消费队列" + data + "成功");
        }
        System.out.println(Thread.currentThread().getName() + "线程叫停了，消费者退出！");
    }

    public void stop() {
        this.FLAG = false;
    }




}