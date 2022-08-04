package com.interview.guava.fluentnull;

/**
 * @author jason.yang
 * @Description
 * @Date 2021-09-29 11:58
 */
public class NullTest {

    public static void main(String[] args) {
        Object obj  = null;
        if(obj instanceof Object) {
            System.out.println("null属于java.lang.Object类型");
        }else {
            System.out.println("null不属于java.lang.Object类型");
        }
    }

}