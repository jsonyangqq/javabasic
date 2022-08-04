package com.interview.jvm;

/**
 * @author jason.yang
 * @Description gc参数某人值查看并修改
 * @Date 2021-04-28 7:17
 */
public class HelloGC {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("******Hello GC");
//        Thread.sleep(Integer.MAX_VALUE);
        byte[] bytes = new byte[50*1024*1024];
    }

}