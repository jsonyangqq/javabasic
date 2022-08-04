package com.interview.javabasic.basic;

/**
 * @author jason.yang
 * @Description 跳出多层嵌套循环
 * 在最外层循环中加一个标识位，然后再内层循环的break后面跟上该标识位
 * @Date 2021-04-16 8:42
 */
public class ExitMutiNestLoop {

    public static void main(String[] args) {

        exitIdentification:
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                System.out.println("i= "+i + ",j= "+j);
                if(i*j == 990) {
                    break exitIdentification;
                }

            }
        }

    }

}