package com.interview.javabasic.exception;

/**
 * @author json.yang
 * @Description
 * @Date 2019-09-24
 * 如果catch中的代码也出现了异常，那么除finally之后catch中报错之后的代码不会再进行执行
 */
public class UnitOne {

    public static void main(String[] args) {
        try {
            int i = 10 / 0;
            System.out.println("try");
        } catch (Exception e) {
            int j = 2 / 0;
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }
        System.out.println("main");
    }

}