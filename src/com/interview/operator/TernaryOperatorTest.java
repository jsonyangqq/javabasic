package com.interview.operator;

/**
 * @author jason.yang
 * @Description 三目运算符
 * @Date 2021-03-04 9:10
 */
public class TernaryOperatorTest {

    public Object getSimpleObject() {
        SimpleObj simpleObj = new SimpleObj();
        return  simpleObj == null ? -1 : simpleObj.getCode();
    }

    public static void main(String[] args) {

        TernaryOperatorTest totest = new TernaryOperatorTest();

        totest.getSimpleObject();


    }

}

class SimpleObj {

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}