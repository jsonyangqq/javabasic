package com.interview.effective.createanddrop;

public enum StatusEnum {

    STAT_ENUM("JDK","java开发工具包"),
    STAT_RGENUM("JRE","java运行环境"),
    STAT_RGENUM1("JRE","java运行环境"),
    STAT_RGENUM2("JRE","java运行环境"),
    STAT_RGENUM3("JRE","java运行环境"),
    STAT_RGENUM4("JRE","java运行环境"),
    STAT_RGENUM5("JRE","java运行环境"),
    STAT_RGENUM6("JRE","java运行环境"),
    STAT_RGENUM7("JRE","java运行环境"),
    STAT_RGENUM8("JRE","java运行环境"),
    STAT_RGENUM9("JRE","java运行环境"),
    STAT_RGENUM10("JRE","java运行环境"),
    STAT_RGENUM11("JRE","java运行环境"),
    STAT_RGENUM12("JRE","java运行环境"),
    STAT_RGENUM13("JRE","java运行环境"),
    STAT_RGENUM14("JRE","java运行环境"),
    STAT_RGENUM15("JRE","java运行环境"),
    STAT_RGENUM16("JRE","java运行环境"),
    STAT_RGENUM17("JRE","java运行环境"),
    STAT_RGENUM18("JRE","java运行环境"),
    STAT_RGENUM19("JRE","java运行环境"),
    STAT_RGENUM20("JRE","java运行环境"),
    STAT_RGENUM21("JRE","java运行环境"),
    STAT_RGENUM22("JRE","java运行环境"),
    STAT_RGENUM23("JRE","java运行环境"),
    STAT_RGENUM24("JRE","java运行环境"),
    STAT_RGENUM25("JRE","java运行环境"),
    STAT_RGENUM26("JRE","java运行环境"),
    STAT_RGENUM27("JRE","java运行环境"),
    STAT_RGENUM28("JRE","java运行环境"),
    STAT_RGENUM29("JRE","java运行环境"),
    STAT_RGENUM30("JRE","java运行环境"),
    STAT_RGENUM31("JRE","java运行环境"),
    STAT_RGENUM32("JRE","java运行环境"),
    STAT_RGENUM33("JRE","java运行环境"),
    STAT_RGENUM34("JRE","java运行环境"),
    STAT_RGENUM35("JRE","java运行环境"),
    STAT_RGENUM36("JRE","java运行环境"),
    STAT_RGENUM37("JRE","java运行环境"),
    STAT_RGENUM38("JRE","java运行环境"),
    STAT_RGENUM39("JRE","java运行环境"),
    STAT_RGENUM40("JRE","java运行环境"),
    STAT_RGENUM41("JRE","java运行环境"),
    STAT_RGENUM42("JRE","java运行环境"),
    STAT_RGENUM43("JRE","java运行环境"),
    STAT_RGENUM44("JRE","java运行环境"),
    STAT_RGENUM45("JRE","java运行环境"),
    STAT_RGENUM46("JRE","java运行环境"),
    STAT_RGENUM47("JRE","java运行环境"),
    STAT_RGENUM48("JRE","java运行环境"),
    STAT_RGENUM49("JRE","java运行环境"),
    STAT_RGENUM50("JRE","java运行环境"),
    STAT_RGENUM51("JRE","java运行环境"),
    STAT_RGENUM52("JRE","java运行环境"),
    STAT_RGENUM53("JRE","java运行环境"),
    STAT_RGENUM54("JRE","java运行环境"),
    STAT_RGENUM55("JRE","java运行环境"),
    STAT_RGENUM56("JRE","java运行环境"),
    STAT_RGENUM57("JRE","java运行环境"),
    STAT_RGENUM58("JRE","java运行环境"),
    STAT_RGENUM59("JRE","java运行环境"),
    STAT_RGENUM60("JRE","java运行环境"),
    STAT_RGENUM61("JRE","java运行环境"),
    STAT_RGENUM62("JRE","java运行环境"),
    STAT_RGENUM63("JRE","java运行环境"),
    STAT_RGENUM64("JRE","java运行环境"),
    STAT_RGENUM65("JRE","java运行环境"),
    STAT_RGENUM66("JRE","java运行环境"),
    STAT_RGENUM67("JRE","java运行环境"),
    STAT_RGENUM68("JRE","java运行环境"),
    STAT_RGENUM69("JRE","java运行环境"),
    STAT_RGENUM70("JRE","java运行环境"),
    STAT_RGENUM71("JRE","java运行环境"),
    STAT_RGENUM72("JRE","java运行环境"),
    STAT_RGENUM73("JRE","java运行环境");




    private StatusEnum(String color) {
        this.color = color;
    }

    private StatusEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private String color;
    private String code;
    private String message;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
