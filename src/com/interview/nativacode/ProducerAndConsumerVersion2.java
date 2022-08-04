package com.interview.nativacode;

import java.util.stream.Stream;

/**
 * @author jason.yang
 * @Description 多生产者对应对消费者
 * 问题一：多生产者和多消费，如果采用wait()和notify的方式会出现线程假死问题，原因是？如果解决呢？
 * 问题二：为啥多生产者和多消费者进行判断是否生产或者消费数据时，要用while循环？
 * @Date 2022-04-09 16:39
 */
public class ProducerAndConsumerVersion2 {

    private static boolean isProduced = false;

    private Object mointerObject = new Object();

    public int count=0;

    /**
     * 生产者线程生产数据的方法
     */
    /**
     * 底层逻辑
     * 这里把if改成while的原因很简单，因为如果是if的话，因为我们之前的生成者线程都是在mointerObject.wait()进行阻塞的,
     * 所以如果用if判断，下次进入会直接跳过判断，进行“生产数据”，反之，消费者也是类似，所以这里需要适用while，while表示
     * 就算你这个wait方法当前放行了，我们还是会进行一次或多次判断的。
     */
    public void producer() {
        synchronized (mointerObject) {
            while (isProduced) {
                try {
                    mointerObject.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count++;
            System.out.println(Thread.currentThread().getName() + "生产者线程生产数据：" + count);
            mointerObject.notifyAll(); //唤醒消费者线程
            isProduced = true;
        }
    }

    /**
     * 消费数据的方法
     */
    public void consumer() {
        synchronized (mointerObject) {
            while (!isProduced) {
                try {
                    mointerObject.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "消费者线程消费数据：" + count);
            mointerObject.notifyAll(); //C2唤醒阻塞的P2
            isProduced = false;
        }
    }

    public static void main(String[] args) {
        ProducerAndConsumerVersion2 pV2 = new ProducerAndConsumerVersion2();
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