package com.interview.classload;

/**
 * @author jason.yang
 * @Description 查看字节码指令
 * @Date 2021-04-29 10:08
 */
public class Person {

    private String name="Jack";
    private int age;
    private final double salary=100;
    private static String address;
    private final static String hobby="Programming";

    private static Object obj=new Object();
    public void say(){
        System.out.println("person say...");
    }
    public static int calc(int op1,int op2){
        op1=3;
        int result=op1+op2;
        Object obj=new Object();
        return result;
    }
    public static void main(String[] args){
        calc(1,2);
    }


}