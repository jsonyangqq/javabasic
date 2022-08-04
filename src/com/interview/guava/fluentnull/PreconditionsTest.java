package com.interview.guava.fluentnull;

import com.google.common.base.Preconditions;

/**
 * @author jason.yang
 * @Description
 * @Date 2021-09-29 14:55
 */
public class PreconditionsTest {

    public void preconditions() throws Exception {

        getPerson(8, "peida");

        getPerson(-9, "peida");

        getPerson(8, "");

        getPerson(8, null);
    }

    public static void getPerson(int age, String neme) throws Exception {
        if (age > 0 && neme != null && neme.isEmpty() != true) {
            System.out.println("a person age:" + age + ",neme:" + neme);
        } else {
            System.out.println("参数输入有误！");
        }
    }

    public void preconditionsTwo() throws Exception {

        getPersonByPrecondition(8,"peida");

        try {
            getPersonByPrecondition(-9,"peida");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            getPersonByPrecondition(8,"");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            getPersonByPrecondition(8,null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void getPersonByPrecondition(int age,String neme)throws Exception{
        Preconditions.checkNotNull(neme, "neme为null");
        Preconditions.checkArgument(neme.length()>0, "neme为\'\'");
        Preconditions.checkArgument(age>0, "age 必须大于0");
        System.out.println("a person age:"+age+",neme:"+neme);
    }


    public static void main(String[] args) throws Exception {
        PreconditionsTest preconditionsTest = new PreconditionsTest();
//        preconditionsTest.preconditions();
        preconditionsTest.preconditionsTwo();
    }

}