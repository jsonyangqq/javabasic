package com.interview.javabasic.array.fail_fast;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jason.yang
 * @Description 使用普通for循环进行操作
 * @Date 2021-02-25 17:16
 */
public class Solution1 {

    public static void main(String[] args) {

        List<String> userNames = new ArrayList<String>() {{
            add("Hollis");
            add("hollis");
            add("HollisChuang");
            add("H");
        }};

        for (int i = 0; i < 1; i++) {
            if (userNames.get(i).equals("Hollis")) {
                userNames.remove(i);
            }
        }
        System.out.println(userNames);

    }

}