package com.interview.javabasic.array.fail_fast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author jason.yang
 * @Description 直接使用Iterator进行操作
 * @Date 2021-02-25 17:16
 */
public class Solution2 {

    public static void main(String[] args) {

        List<String> userNames = new ArrayList<String>() {{
            add("Hollis");
            add("hollis");
            add("HollisChuang");
            add("H");
        }};

        Iterator iterator = userNames.iterator();

        while (iterator.hasNext()) {
            if (iterator.next().equals("Hollis")) {
                iterator.remove();
            }
        }
        System.out.println(userNames);

    }

}