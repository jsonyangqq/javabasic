package com.interview.jvm.oom;

/**
 * @author jason.yang
 * @Description 创建线程导致的内存溢出
 * 线程数 * (最大栈容量) + 最大堆值 + 其他内存(忽略不计或者一般不改动) = 机器最大内存
 * 所以如果你电脑内存过大，其实这个结果是很难试不出来的
 * @Date 2021-04-29 12:43
 */
public class JavaVmStackOOM {

    public int i = 0;

    private void dontstop() {
        while (true) {
            i++;
            System.out.println(i);
        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontstop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVmStackOOM oom = new JavaVmStackOOM();
        oom.stackLeakByThread();
    }


}