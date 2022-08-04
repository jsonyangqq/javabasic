package com.interview.test;

/**
 * @author jason.yang
 * @Description
 * @Date 2021-02-24 21:22
 */
public class CloneExample {

    private String a;

    private String b;

    @Override
    protected CloneExample clone() throws CloneNotSupportedException {
        return (CloneExample) super.clone();
    }
}