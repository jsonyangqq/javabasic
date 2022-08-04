package com.interview.javabasic.datatype;

/**
 * @author json.yang
 * @Description 字符串的不变性
 * @Date 2019-09-30
 */
public class StringInvariance {

    public static void main(String[] args) {
        String str = "abc";
        str = "hello";
        System.out.println(str);
    }

}