package com.interview.javabasic.array;

import java.util.Arrays;

/**
 * @author json.yang
 * @Description 测试题
 * @Date 2019-10-08
 */
public class TestArrayDemo {


    public static void main(String[] args) {
        int[] arr = {2,3,4,8};  //[0,3,8,8]
        change(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void change(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if(i % 2 == 0){
                arr[i] *=i;
            }
        }

    }

}