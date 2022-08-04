package com.interview.arithmetic.queue;

import java.util.Arrays;

/**
 * @author jason.yang
 * @Description
 * @Date 2021-01-07 10:23
 */
public class MyCircularQueueTest {


    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(2);
        circularQueue.enQueue(1);    //                   2 > 3
        circularQueue.enQueue(2);
        circularQueue.deQueue();
        System.out.println(Arrays.toString(circularQueue.getData()));
        circularQueue.enQueue(3);
        System.out.println(Arrays.toString(circularQueue.getData()));
        circularQueue.deQueue();
        circularQueue.enQueue(3);
        System.out.println(Arrays.toString(circularQueue.getData()));
        circularQueue.deQueue();
        circularQueue.enQueue(3);
        System.out.println(Arrays.toString(circularQueue.getData()));
        circularQueue.deQueue();
        System.out.println(circularQueue.Front());

    }

}