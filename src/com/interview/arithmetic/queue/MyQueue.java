package com.interview.arithmetic.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jason.yang
 * @Description 实现一个简单的队列
 * 知道了队列的特点我们才能够更好的实现我们自己的队列结构  ->  先进先出
 * @Date 2021-01-05 11:05
 */
public class MyQueue {

    /*队列中的所有元素集合*/
    List<Integer> data;

    /*队头元素头指针*/
    int inx_start;

    public MyQueue() {
        data = new ArrayList<>();
        inx_start = 0;
    }

    /**
     * 进行入队操作
     * @param element
     */
    public boolean enqueue(int element) {
        data.add(element);
        return true;
    }

    public boolean dequeue() {
        if(isEmpty()) {
            return false;
        }
        data.remove(inx_start);
        return true;
    }

    public boolean isEmpty() {
        return inx_start >= data.size();
    }


    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        System.out.println(myQueue.data);
        myQueue.dequeue();
        System.out.println(myQueue.data);
        myQueue.dequeue();
        System.out.println(myQueue.data);
        myQueue.dequeue();
        System.out.println(myQueue.data);
    }




}