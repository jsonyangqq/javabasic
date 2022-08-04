package com.interview.util;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author jason.yang
 * @Description
 * @Date 2021-07-14 15:41
 */
public class TestSplitList {

    public static void main(String[] args) {

        String[] str = {"1","2","3","4"};
        ArrayList list = new ArrayList(Arrays.asList(str));
        list.remove("4");
        System.out.println(list);

        ArrayList<Object> objects = Lists.newArrayList();
        System.out.println(objects);

    }

}