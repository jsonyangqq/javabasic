package com.interview.expression;

/**
 * @author jason.yang
 * @Description 三目表达式概念
 * @Date 2021-02-24 10:32
 */
public class TernaryExpress {

    public static void main(String[] args) {
        Object o1 = true ? new Integer(1) : new Double(2.0);
        Object o2;
        Byte b = 127;
        Byte b1 = 127;

        boolean flag = true;

        String str = new String("abc");

        if(true) {
            o2 = new Integer(1);
        } else {
            o2 = new Double(2.0);
        }
        System.out.print(o1);
        System.out.print(" ");
        System.out.print(o2);

    }

}