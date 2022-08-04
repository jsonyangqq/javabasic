package com.interview.arithmetic.strOpt;

/**
 * @author jason.yang
 * @Description 反转整数
 * @Date 2021-08-27 12:16
 */
public class ReverseInteger {

    public int reverse(int x) {
        int maxValue = Integer.MAX_VALUE;
        int minValue = Integer.MIN_VALUE;
        boolean symbolFlag = true;
        if(x<0) {
            symbolFlag = false;
        }
        //取绝对值
        long bigNumber = x;
        bigNumber = Math.abs(bigNumber);
        char[] chars = String.valueOf(bigNumber).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
        }
        int left = 0;
        int right = chars.length - 1;
        while(left < right) {
            swap(chars, left, right);
            left++;
            right--;
        }
        bigNumber = Long.parseLong(String.valueOf(chars));
        if(bigNumber > maxValue || bigNumber < minValue) {
            return 0;
        }
        x = (int)bigNumber;
        return symbolFlag ? x : -x;
    }

    private void swap(char[] a,int left, int right) {
        char temp = a[right];
        a[right] = a[left];
        a[left] = temp;
    }

    public static void main(String[] args) {

        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(-123));

    }

}