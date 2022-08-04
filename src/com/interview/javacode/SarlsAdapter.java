package com.interview.javacode;

/**
 * @author jason.yang
 * @Description
 * @Date 2021-02-27 8:03
 */
public class SarlsAdapter extends AbstractAnimal{

    @Override
    public void eat() {

    }

    protected Object testOverride()throws Exception {
        System.out.println("测试");
        return null;
    }


}