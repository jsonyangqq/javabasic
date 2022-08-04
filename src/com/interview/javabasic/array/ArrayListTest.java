package com.interview.javabasic.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jason.yang
 * @Description arrayList在jdk8和jdk8之前存在的问题
 * @Date 2021-02-25 9:50
 */
public class ArrayListTest {

    public static void main(String[] args) {

        List<Integer> sList = Arrays.asList(1,2,3);
        System.out.println(sList);
        // JDK-6260652问题  ArrayStoreException异常
        Object[] objects = sList.toArray();
        objects[1] = new Object();


    }

}