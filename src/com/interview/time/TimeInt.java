package com.interview.time;

/**
 * @author jason.yang
 * @Description
 * @Date 2022-04-22 9:43
 */
public interface TimeInt {

    default void pay() {
        System.out.println("默认实现方法");
    }

    default void onmessage() {

    }

}