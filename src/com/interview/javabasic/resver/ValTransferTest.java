package com.interview.javabasic.resver;

/**
 * @author jason.yang
 * @Description 值传递测试
 * @Date 2020-12-24 7:22
 */
public class ValTransferTest {

    static int x=0;
    public static void main(String[] args)  {
//        int x=0;
//        change(x);
        ValTransferTest s = new ValTransferTest();
        s.change(3);
        System.out.println(x);
    }
     void change(int i){
        this.x=7;
    }

}