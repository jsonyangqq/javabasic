package com.interview.pecs;

import java.util.Arrays;

/**
 * @author json.yang
 * @Description lsp原则  Liskov替换原则
 * @Date 2020-07-09
 */
public class LspPrinciple {

    static Number method(Number num) {
        return 1;
    }

    public static void main(String[] args) {
        Number[] numbers = new Integer[3];
        numbers[0] = 1;
        numbers[1] = 2;
        numbers[2] = 3;
        System.out.println(Arrays.toString(numbers));

        Object result = method(new Integer(2)); //correct
//        Number result1 = method(new Object()); //error
//        Integer result2 = method(new Integer(2)); //error

    }

}