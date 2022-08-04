package com.interview.javabasic.array.fail_fast;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jason.yang
 * @Description 重现快速失败
 * @Date 2021-02-25 17:18
 */
public class RepeatFailSafeTest {

    public static void main(String[] args) {
        List<String> userNames = new ArrayList<String>() {{
            add("Hollis");
            add("hollis");
            add("HollisChuang");
            add("H");
        }};

        for (String userName : userNames) {
            if (userName.equals("Hollis")) {
                userNames.remove(userName);
            }
        }

        System.out.println(userNames);
    }

}