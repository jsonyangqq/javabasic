package com.interview.operator;

/**
 * @author jason.yang
 * @Description
 * @Date 2022-08-04 16:06
 */
public class A implements B{

    public static void main(String[] args) {

        int i;
        A a1 = new A();
        i = a1.k;
        System.out.println("i=" + i);

    }

}

interface B {
    // 接口中定义的其实就是常量本身，因为前面默认会加上 public static final
    int k = 10;

}