package com.interview.collection.collectiontest;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * @author jason.yang
 * @Description
 * @Date 2022-03-23 21:32
 */
public class MainTest {

    public static void main(String[] args) {

        List<Integer> argsList =  Lists.newArrayList();
        argsList.add(2);
        argsList.add(3);
        argsList.add(4);
        argsList.add(5);
        argsList.add(1);
//        Object[] elementData = argsList.toArray();
//        System.arraycopy(elementData, 2+1, elementData, 2,
//                1);
//        System.out.println(Arrays.toString(elementData));
        boolean remove = argsList.remove(Integer.valueOf(4));
        System.out.println(remove);

        System.out.println(Arrays.toString(argsList.toArray()));

    }

}