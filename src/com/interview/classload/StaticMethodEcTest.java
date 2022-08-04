package com.interview.classload;

/**
 * @author jason.yang
 * @Description 静态方法执行测试
 * @Date 2021-02-24 10:15
 */
public class StaticMethodEcTest {

    public static void hello() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        StaticMethodEcTest smet = null;
        smet.hello();
    }

}