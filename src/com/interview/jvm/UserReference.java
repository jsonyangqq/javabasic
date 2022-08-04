package com.interview.jvm;

/**
 * @author jason.yang
 * @Description 对象引用
 * @Date 2022-07-25
 */
public class UserReference {

    private Integer age;
    private final String name = "Jason";
    private Double salary = 10000.0;
    private static String address;

    private Object obj = new Object();

    public void say() {
        System.out.println("Jason say!");
    }

    public static Integer calc(Integer op1, Integer op2) {
        op1 = 3;
        Integer result = op1 + op2;
        Object obj = new Object();
        return result;
    }

    public static void main(String[] args) {
        System.out.println(calc(1,2));
    }
}