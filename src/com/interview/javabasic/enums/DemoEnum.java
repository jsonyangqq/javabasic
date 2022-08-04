package com.interview.javabasic.enums;



/**
 * @author jason.yang
 * @Description
 * @Date 2021-10-11 21:53
 */
public enum  DemoEnum implements Feature {

    FIRST("第一个"),
    SECOND("第二个"),
    THIRD("第三个");


    DemoEnum() {
        mask = (1 << ordinal());
    }

    DemoEnum(String desc) {
        mask = (1 << ordinal());
        this.desc = desc;
    }

    private final int mask;


    private String desc;

    @Override
    public final int getMask() {
        return mask;
    }

    @Override
    public Feature[] listAll() {
        return DemoEnum.values();
    }

    public String getDesc() {
        return desc;
    }

}