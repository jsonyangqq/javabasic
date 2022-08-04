package com.interview.javabasic.string;

/**
 * @author jason.yang
 * @Description
 * @Date 2021-05-19 11:29
 */
public class StringCompareVal {

    public static void main(String[] args) {
        String str = "abcd";
        String str1 = "abcd";
        String str2 = new String("abcd");
        System.out.println(str == str1);
        System.out.println(str1 == str2);
    }

}