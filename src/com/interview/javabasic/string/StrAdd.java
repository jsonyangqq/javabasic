package com.interview.javabasic.string;

import java.math.BigDecimal;

/**
 * @author jason.yang
 * @Description 字符串相加
 * @Date 2021-04-13 21:17
 */
public class StrAdd {

    private static String javaAdd1(String num1, String num2) {
        // 补位为0，让两个数位数相等
        while (true)
        {
            if(num1.length() == num2.length())
            {
                break;
            } else
            {
                if(num1.length() < num2.length())
                {
                    num1 = "0" + num1;
                }else
                {
                    num2 = "0" + num2;
                }
            }
        }
        //将两个数字字符分成字符串进行计算
        char[] num1Char = num1.toCharArray();
        char[] num2Char = num2.toCharArray();
        int length = num1.length();
        //准备存储结果的数组
        //预留一位，以供进位
        char[] num = new char[length+1];
        for(int i=0;i<length+1;i++)
        {
            num[i] = '0';
        }

        for(int i = length-1;i >= 0;i--) {
            char num1_i = num1Char[i];
            char num2_i = num2Char[i];
            int addResult = 0;
            int index = i+1;
            addResult = (num1_i + num2_i) - ('0' * 2);
            if(num[index] >'0')
            {
                addResult += 1;
            }
            if (addResult > 9)
            {
                //代表有进位
                num[index-1] = '1';
                addResult = addResult -10;
            }
            num[index] = (char) (addResult+'0');
        }
        // 去除前置0
        int index = 0;
        for(int i=0;i<num.length;i++)
        {
            if(num[i] == '0')
            {
                index = i+1;
            }else
            {
                break;
            }
        }
        String s = "";
        for(int i=index;i<num.length;i++)
        {
            s = s+ num[i];
        }
        return s;
    }

    public static void main(String[] args) {
        String a = "1111111111111111111111111111";
        String b = "4555556668";
        System.out.println(javaAdd1(a,b));
        BigDecimal b1 = new BigDecimal("1111111111111111111111111111");
        BigDecimal c2 = new BigDecimal(900);
        System.out.println(b1.add(c2));
    }


}