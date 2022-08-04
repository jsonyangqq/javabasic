package com.interview.javabasic.array.fail_fast;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author jason.yang
 * @Description 直接使用fail-safe的集合类  ConcurrentLinkedDeque
 * @Date 2021-02-25 17:23
 */
public class Solution4 {

    public static void main(String[] args) {

        ConcurrentLinkedDeque<String> userNames = new ConcurrentLinkedDeque<String>() {{
            add("Hollis");
            add("hollis");
            add("HollisChuang");
            add("H");
        }};

        for (String userName : userNames) {
            if (userName.equals("Hollis")) {
                userNames.remove();
            }
        }

        System.out.println(userNames);
    }

}