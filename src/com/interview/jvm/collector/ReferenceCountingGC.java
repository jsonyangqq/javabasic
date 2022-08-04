package com.interview.jvm.collector;

/**
 * @author jason.yang
 * @Description 引用计数法中循环引用问题
 * @Date 2021-04-30 9:44
 */
public class ReferenceCountingGC {

    public Object instance = null;
    private static final int _1MB = 1024 * 1024;

    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;
        System.gc();
    }

    public static void main(String[] args) {
        testGC();
    }

}