package com.interview.arithmetic.strOpt;

import java.util.Arrays;

/**
 * @author jason.yang
 * @Description 反转字符串
 * @Date 2021-08-27 11:30
 */
public class ReverseString {

    public void reverseString(char[] s) {
        /**
         我们可以使用原地旋转数组来解决这个问题
         第一个数字和最后一个交换，第二个和倒数第二个数交换，依此类推
         */
        if(s == null || s.length == 1) {
            return;
        }
        int left = 0;
        int right = s.length-1;
        while(left<right) {
            swap(s, left, right);
            left++;
            right--;
        }
        System.out.println(Arrays.toString(s));
    }

    private void swap(char[] a,int left, int right) {
        char temp = a[right];
        a[right] = a[left];
        a[left] = temp;
    }

    public static void main(String[] args) {

        ReverseString reverseString = new ReverseString();
//        char[] s = {'h','e','l','l','o'};
        char[] s = {'H','a','n','n','a','H'};
        reverseString.reverseString(s);
        int maxValue = Integer.MAX_VALUE;
        int minValue = Integer.MIN_VALUE;
        char[] chars = String.valueOf(maxValue).toCharArray();
        System.out.println(Integer.parseInt("0012"));

    }

}