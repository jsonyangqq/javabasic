package com.interview.javabasic.array;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * @author json.yang
 * @Description 数组转换成字符串
 * @Date 2019-10-08
 */
public class ArrayCoverStr {

    public static void main(String[] args) {
        System.out.println("-- -----------------  方式一实现数组转换成字符串  -------------------");
        methodA();
        System.out.println("-- -----------------  方式二实现数组转换成字符串  -------------------");
        methodB();
        System.out.println("-- -----------------  方式三实现数组转换成字符串  -------------------");
        methodC();
    }

    public static void methodA(){
        String[] arr = {"laowang", "stone", "wanglei"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if(i != arr.length-1){
                sb.append(",");
            }
        }
        System.out.println(sb.toString());
    }

    public static void methodB(){
        String[] arr = {"laowang", "stone", "wanglei"};
        String str = Arrays.toString(arr);
        System.out.println(str);
    }

    public static void methodC(){
        String[] arr = {"laowang", "stone", "wanglei"};
        String str = StringUtils.join(Arrays.asList(arr), ",");
        System.out.println(str);
    }

}