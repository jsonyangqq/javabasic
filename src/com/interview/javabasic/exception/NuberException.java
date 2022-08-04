package com.interview.javabasic.exception;

/**
 * @author json.yang
 * @Description 包装类数据异常 - 差异
 * @Date 2019-09-24
 */
public class NuberException {


    public static void main(String[] args) {
        //Exception in thread "main" java.lang.NumberFormatException: null
//        int i = Integer.parseInt(null);
//        System.out.println(i);
        //Exception in thread "main" java.lang.NullPointerException
        double d = Double.parseDouble(null);
        System.out.println(d);

    }

}