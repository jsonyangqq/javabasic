package com.interview.javabasic.keyword;

/**
 * @author jason.yang
 * @Description
 * @Date 2021-04-14 10:12
 */
public class StaticClass {

    private static String STR = "AAA";

    private String bb = "BBB";

    public StaticClass() {
        System.out.println("执行了构造器");
    }


    public static void test() {
        System.out.println("开始执行了");

    }

    public static void main(String[] args) {
        StaticClass.test();
//        System.out.println(bb);
    }


}