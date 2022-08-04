package com.interview.javabasic.fortest;


import java.util.ArrayList;
import java.util.List;

public class ForRemoveTest {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        System.out.println(System.console());
        System.out.println("当前系统的版本:"+System.getProperty("java.class.path"));
        for (String s : stringList) {
            if("1".equals(s)){
                stringList.remove(s);
            }
        }
    }

}
