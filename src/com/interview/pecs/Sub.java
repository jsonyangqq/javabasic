package com.interview.pecs;

/**
 * @author json.yang
 * @Description 子类
 * @Date 2020-07-09
 */
public class Sub extends Super{

    @Override
    Integer method(Number n) {
        return (Integer) super.method(n);
    }
}