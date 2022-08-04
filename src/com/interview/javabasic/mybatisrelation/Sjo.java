package com.interview.javabasic.mybatisrelation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jason.yang
 * @Description
 * @Date 2021-12-22 14:19
 */
public class Sjo {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        AtomicInteger i = new AtomicInteger();
        list.stream().anyMatch(l -> {
            if("b".equals(l)) {
                return true;
            }
            i.getAndIncrement();
            return false;
        });
        System.out.println(i.get());

    }

}