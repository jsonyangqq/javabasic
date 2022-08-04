package com.interview.arithmetic;

/**
 * @author jason.yang
 * @Description
 * @Date 2021-01-10 8:47
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {

        int rightInx = nums.length;
        boolean flag = false;
        for(int i=0;i<nums.length;i++) {
            flag = false;
            for(int j=0;j<nums.length;j++) {
                int repeatCount = 0;
                if(j>i && nums[i]==nums[j]) {
                    repeatCount++;
                    flag = true;
                    continue;
                }
                if(flag) {
                    rightInx--;
                    nums[j-1] = nums[j];
                }
            }
        }

        return rightInx;

    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] nums = new int[]{1,1,2};
        System.out.println(removeDuplicates.removeDuplicates(nums));

        int a = 21474836;
        int b = 2147483646;
        System.out.println((a+b)/2);
        System.out.println(a+(b-a)/2);

        System.out.println(1/2);

    }

}