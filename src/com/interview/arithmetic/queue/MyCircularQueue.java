package com.interview.arithmetic.queue;

/**
 * @author jason.yang
 * @Description 循环队列设计
 * @Date 2021-01-07 9:14
 */
public class MyCircularQueue {

    private int[] data;
    private int head;
    private int tail;
    /*队列实际长度*/
    private int size;

    public MyCircularQueue(int k) {
        size = 0;
        this.data = new int[k];
        this.head = -1;
        this.tail = -1;
    }

    public boolean enQueue(int value) {
        if(isFull()) {
            return false;
        }
        if(isEmpty()) {
            head = 0;
        }
        if(head == data.length) {
            head--;
        }
        if(tail == data.length-1) {
            tail = -1;
        }
        tail++;
        size++;
        data[tail] = value;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()) {
            return false;
        }
        data[head] = 0;
        if(head == tail) {
            head = -1;
            tail = -1;
        }
        head++;
        size--;
        return true;
    }

    public int Front() {
        if(isEmpty()) {
            return -1;
        }
        if(head == data.length) {
            return data[head-1];
        }
        return data[head];
    }

    public int Rear() {
        if(isEmpty()) {
            return -1;
        }
        if(head == data.length) {
            return data[tail-1];
        }
        return data[tail];
    }

    public boolean isEmpty() {
        if(size == 0) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if(size ==data.length) {
            return true;
        }
        return false;
    }

    public int[] getData() {
        return this.data;
    }

}