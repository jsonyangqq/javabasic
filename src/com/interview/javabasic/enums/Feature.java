package com.interview.javabasic.enums;

/**
 * @author jason.yang
 * @Description
 * @Date 2021-10-11 21:57
 */
public interface Feature {

    /**
     * 获取特性（掩码）
     */
    int getMask();

    /**
     * 所有特性
     */
    Feature[] listAll();

}