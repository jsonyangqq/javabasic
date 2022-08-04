package com.interview.jvm.oom;

/**
 * @author jason.yang
 * @Description 使用-Xss参数减少内存容量
 * VM args: -Xss128k
 * @Date 2021-04-29 12:18
 */
public class JavaVMStackSOF {

    private int stackSize = 1;

    public void stackLeak() {
        stackSize++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
        try {
            javaVMStackSOF.stackLeak();
        }catch (Throwable e) {
            System.out.println("stack length:"+javaVMStackSOF.stackSize);
            throw e;
        }
    }

}