package com.interview.jvm;

/**
 * @author jason.yang
 * @Description 理解字符串常量池分布
 * @Date 2021-02-24 17:16
 */
public class NewStringTest {

    public static void main(String[] args) {
        String s = new String("abc");

        String a ="张三";

        String b ="张";

        String c ="三";

        String d = b + c;

        System.out.println(a == d);// false
    }

}