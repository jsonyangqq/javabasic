package com.interview.arithmetic;

import java.util.Arrays;

/**
 * @author jason.yang
 * @Description 只出现一次的数字
 * 解题思路：
 * 3种方式解题
 * 第一种方式：时间复杂度O(n),空间复杂度O(n),可以使用Set集合，将数组中的数依次添加到集合中去，如果是第二次添加，则进行删除，最后就只剩下一个元素没添加进去了
 * 第二种方式：空间复杂度是O(1),时间复杂度2*O(n);先对数据进行排序，然后把数据分成二二进行比较，如果有一对二二比较结果中出现了不相等的情况，则我们取出这个数
 * 第三种方式：时间复杂度O(n),空间复杂度O(1),我们可以使用异或运算，因为异或运算有一个特性，满足数学中的交换律
 * @Date 2021-01-03 18:30
 */
public class OnlyOneNumber {

    public int singleNumber(int[] nums) {
        //1.先排序，排序后只有可能出现3中情况，第一个数，中位数，和最后一个数
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length > 2) {
            Arrays.sort(nums);
            System.out.println(Arrays.toString(nums));
            for (int i = 0; i < nums.length; i++) {
                if(i%2 ==0) {
                    if(nums[i] != nums[i+1])
                    return nums[i];
                }

            }
        }
        return -1;
    }

    public int singleNumberTwo(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0] ^=nums[i];
        }
        return nums[0];
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-336,513,-560,-481,-174,101,-997,40,-527,-784,-283,-336,513,-560,-481,-174,101,-997,40,-527,-784,-283,354};
        OnlyOneNumber oneNumber = new OnlyOneNumber();
        int i = oneNumber.singleNumberTwo(nums);
        System.out.println(i);

    }

}