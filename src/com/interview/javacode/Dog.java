package com.interview.javacode;

import java.text.ParseException;

/**
 * @author jason.yang
 * @Description
 * @Date 2021-02-27 8:01
 */
public class Dog extends SarlsAdapter{

    @Override
    public void eat() {
        super.eat();
    }

    @Override
    public Integer testOverride() throws ParseException {
        return 0;
    }
}