package com.interview.jvm.oom;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jason.yang
 * @Description 字符串常量池内存溢出
 * 打印jvm参数信息 -XX:+PrintFlagsFinal
 * 在jdk6中设置永久代内存区域大小 -Xms6M -Xmx6M -XX:PermSize=6M -XX:MaxPermSize=6M
 * 在jdk7中设置堆内存区域大小 -Xms6M -Xmx6M -XX:PermSize=6M -XX:MaxPermSize=6M
 * 在jdk8中设置堆内存区域大小 -Xms6M -Xmx6M -XX:MetaspaceSize=6M -XX:MaxMetaspaceSize=6M
 * @Date 2021-04-29 16:16
 */
public class StringConstantPoolOOM {



    public static void main(String[] args) {
        //使用Set保存者常量池的引用，避免Full GC回收常量池行为
        Set<String> set = new HashSet<String>();
        short i = 0;
        Integer total = 0;
        while (true) {
            System.out.println(i++);
            String str = String.valueOf(i).intern();
            // set 引用会指向里面的string字符串了，导致创建的字符串不是垃圾
            total+= str.length();
            System.out.println(total);
            set.add(str);
        }

    }

}
