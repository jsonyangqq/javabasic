package com.interview.arithmetic.twosum;

/**
 * @author jason.yang
 * @Description 二个字符串的和
 * @Date 2021-08-06 11:55
 */
public class StrTwoNumbers {

    public String addStrings(String num1, String num2) {
        if(num1 == null || num2 == null) {
            return null;
        }
        StringBuilder s = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while(i >= 0 || j >= 0 || carry != 0) {
            int x = i < 0 ? 0 : num1.charAt(i--) - '0';
            int y = j < 0 ? 0 : num2.charAt(j--) - '0';
            int sum = x + y + carry;
            s.append(sum % 10);
            carry = sum / 10;
        }
        return s.reverse().toString();
    }

    public static void main(String[] args) {
        StrTwoNumbers strTwoNumbers = new StrTwoNumbers();
        String str1 = "100";
        String str2 = "1000";
        System.out.println(strTwoNumbers.addStrings(str1, str2));
    }

}