package com.interview.javabasic.mutithread.jdkutil;

/**
 * @author jason.yang
 * @Description 召唤神龙的任务
 * @Date 2022-08-04 17:00
 */
public class CallDragonTask implements Runnable{


    @Override
    public void run() {
        System.out.println("七颗龙珠已经集器，唤出神龙！");
    }


}