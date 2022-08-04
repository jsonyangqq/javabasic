package com.interview.javabasic.array.fail_fast;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jason.yang
 * @Description 使用java8提供的filter进行过滤
 * @Date 2021-02-25 17:23
 */
public class Solution3 {

    public static void main(String[] args) {

        List<String> userNames = new ArrayList<String>() {{
            add("Hollis");
            add("hollis");
            add("HollisChuang");
            add("H");
        }};

        userNames = userNames.stream().filter(userName -> !userName.equals("Hollis")).collect(Collectors.toList());
        System.out.println(userNames);

    }

}