package com.interview.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jason.yang
 * @Description java堆溢出演示 -XX:+HeapDumpOnOutOfMemoryError参数出现内存溢出的时候，可以记录快照便于时候分析问题
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @Date 2021-04-29 10:57
 */
public class HeapOOM {

    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }

}