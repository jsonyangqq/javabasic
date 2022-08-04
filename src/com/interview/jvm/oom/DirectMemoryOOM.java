package com.interview.jvm.oom;

import sun.misc.Unsafe;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

/**
 * @author jason.yang
 * @Description 使用unsafe分配本机内存
 * VM Args: -Xmx20M -XX:MaxDirectMemorySize=10M
 * NIO程序会很容易出现
 * @Date 2021-04-29 17:32
 */
public class DirectMemoryOOM {

    private static final  int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception {
        System.out.println("配置的maxDirectMemory的大小为："+sun.misc.VM.maxDirectMemory() / 1024 /1024 + "MB");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //我们系统设置的最大直接内存大小为10M，但是我们这里要使用11M，看看会不会有什么问题
        ByteBuffer allocate = ByteBuffer.allocateDirect(11 * 1024 * 1024);

    }

}