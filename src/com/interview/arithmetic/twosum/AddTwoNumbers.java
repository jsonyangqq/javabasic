package com.interview.arithmetic.twosum;

import com.interview.arithmetic.ListNode;
import java.math.BigDecimal;

/**
 * @author jason.yang
 * @Description 二个数的和
 * @Date 2021-08-04 9:34
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1.val == 0 && l2.val == 0 && l1.next == null && l2.next == null) {
            return new ListNode(0);
        }
        String str1 = nodeCovertStr(l1);
        String str2 =nodeCovertStr(l2);
        String sum = addStrings(str1,str2);
        char[] chars = sum.toCharArray();
        //先初始化一个哨兵节点
        ListNode newNode = new ListNode(0);
        ListNode nextNode = newNode;
        for (int i = chars.length-1; i >=0; i--) {
            ListNode nextNewNode = nextNode;
            nextNewNode.next = new ListNode(Character.getNumericValue(chars[i]));
            nextNode = nextNewNode.next;
        }
        //将头节点置换为空，下一个节点变化成为头节点i
        ListNode head = newNode.next;
        newNode.next = null;
        return head;
    }

    /**
     * 将node反后转再将节点转换成字符串
     * @param head
     * @return
     */
    public static String nodeCovertStr(ListNode head) {
        ListNode prev = head;
        ListNode current = head.next;
        prev.next = null;
        while(current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        String str = "";
        while (prev.next != null) {
            str += prev.val;
            prev = prev.next;
        }
        str += prev.val;
        return str;
    }

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
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = new ListNode(2,new ListNode(4,new ListNode(9)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(9))));
        System.out.println(addTwoNumbers.addTwoNumbers(l1, l2).toString());
    }

}