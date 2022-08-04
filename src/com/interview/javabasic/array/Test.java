package com.interview.javabasic.array;

import java.util.Scanner;

/**
 * @author json.yang
 * @Description fj
 * @Date 2019-12-06
 */
public class Test {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        if(str.length()<=12){
            if(str.length()>=0 && str.length()<=10 && !str.contains("0")) {
                System.out.println(1);
            }else if(str.length() == 11 && str.length()%3 != 1){
                System.out.println(2);
            }else if(str.length() == 12 && str.length()%3 != 1){
                System.out.println(3);
            }else if(str.length()%3 == 1){
                char[] chars = str.toCharArray();
                for (int i = 1; i <= chars.length; i++) {
                    if(i%3 == 1 && i=='0'){
                        System.out.println(1);
                    }
                }
            }
        }else {
            System.out.println("输入位数不能超过12位！");
        }

    }

}