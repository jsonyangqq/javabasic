package com.interview.javacode;

/**
 * @author jason.yang
 * @Description
 * @Date 2021-10-10 11:45
 */
public class TestThreeCodition {

    public static void main(String[] args) {

        Integer a = 100;
        Integer b = 100;
        Integer c = null;
        Boolean flag = false;
        Integer result = (flag) ? a*b : c;

        System.out.println(result);
    }

}