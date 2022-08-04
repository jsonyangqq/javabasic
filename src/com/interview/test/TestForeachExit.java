package com.interview.test;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jason.yang
 * @Description 测试lambda表达式foreach退出
 * @Date 2022-04-20 9:13
 */
public class TestForeachExit {

    public static void main(String[] args) {
        List<String> str = new ArrayList<>();
        str.add("1");
        str.add("2");
        str.add("3");
        str.add("a");
        str.add("b");
        str.add("c");
        boolean b = str.stream().filter(s -> StringUtils.isNoneBlank(s)).anyMatch(s -> {
            System.out.println(s);
            if ("p".equals(s)) {
                return true;
            }
            return false;
        });
        System.out.println(b);
    }

}