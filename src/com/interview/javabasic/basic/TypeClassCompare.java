package com.interview.javabasic.basic;

import java.lang.reflect.Type;

/**
 * @author jason.yang
 * @Description
 * @Date 2022-08-05 7:28
 */
public class TypeClassCompare {

    private String name;

    /**
     * 构造方法调用要采用this关键字调用才行
     */
    public TypeClassCompare() {
        this("abc");
    }

    public TypeClassCompare(String name) {
        this.name = name;
    }


    public static void main(String[] args) {

        Integer i = 42;
        Long l = 42l;
        Double d = 42.0;

        System.out.println(i.equals(42));

    }

}