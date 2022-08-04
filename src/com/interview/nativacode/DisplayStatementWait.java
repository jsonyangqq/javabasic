package com.interview.nativacode;

/**
 * @author jason.yang
 * @Description 显示声明wait方法
 * 这个例子主要说明wait方法必须要和Synchronized搭配适用，不然会报错 java.lang.IllegalMonitorStateException
 * @Date 2022-04-09 22:31
 */
public class DisplayStatementWait {

    public static void main(String[] args) {

        DisplayStatementWait dsw = new DisplayStatementWait();
        try {
//            synchronized (dsw) {
                dsw.wait();
//            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("-0----------");

        dsw.notify();

    }

}