package com.interview.javabasic.array.fail_fast;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jason.yang
 * @Description 使用增强for循环时，我们只需要在add()/remove()方法后面立刻跳出循环就可以了，也就是避免下一次的next()发生
 * @Date 2021-02-25 17:24
 */
public class Solution5 {

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
                break;
            }
        }
        System.out.println(userNames);

    }

}