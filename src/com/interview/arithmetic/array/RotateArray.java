package com.interview.arithmetic.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jason.yang
 * @Description 旋转数组
 * @Date 2021-08-25 11:57
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        //原数组上改变数组
        int sourceLen = nums.length;
        if(k !=0 && nums.length > 1) {
            if(k > nums.length) {
                k = k % sourceLen;
            }
            /**
             * i=0 i+k = 3   3<7   nums[3] = nums[0] = 1
             * i=1 i+k = 4   4<7   nums[4] = nums[1] = 2
             * i=2 i+k = 5   5<7   nums[5] = nums[2] = 3
             * i=3 i+k = 6   6<7   nums[6] = nums[3] = 4
             */
            //新数组存储超出原数组长度的值  需要从后往前移动
            int[] newNums = new int[k];
            for(int i=nums.length-1;i>=0;i--) {
                if(i+k < sourceLen) {   //0+3 < 7 and 1+3 < 7 and 2+3 < 7 and 3+3 < 7
                    nums[i+k] = nums[i];
                }else {
                    //移动到外面的值就可以保存到新数组当中存储  6+3-7=2 i=4时候需要移动
                    // 5+3-7=1   6
                    // 4+3-7=0   5
                    newNums[i+k-sourceLen] = nums[i];
                }
            }

            for(int j=0;j<newNums.length;j++) {
                nums[j] = newNums[j];
            }

            System.out.println(Arrays.toString(nums));
            System.out.println(Arrays.toString(newNums));


        }

    }

    /**
     * 思路2：双重循环
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        int sourceLen = nums.length;
        if(k !=0 && nums.length > 1) {
            if(k > nums.length) {
                k = k % sourceLen;
            }
            for (int i = 0; i < k; i++) {
                int temp = nums[sourceLen-1];
                for (int j = nums.length-1; j >=0; j--) {
                    if(j == sourceLen - 1) {
                        //从最后一个数字开始走
                        temp = nums[j];
                        continue;
                    }
                    //不是最后一个位置的数都要进行后移操作
                    nums[j] = nums[j-1];
                }
                nums[0] = temp;
            }
        }
    }


    /**
     * 循环交换
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public void rotate_3(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        // 第一次交换完毕后，前 k 位数字位置正确，后 n-k 位数字中最后 k 位数字顺序错误，继续交换
        for (int start = 0; start < nums.length && k != 0; n -= k, start += k, k %= n) {
            for (int i = 0; i < k; i++) {
                swap(nums, start + i, nums.length - k + i);
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }







    public static void main(String[] args) {

        RotateArray rotateArray = new RotateArray();
        int[] arr = {1,2,3,4,5,6,7};
        rotateArray.rotate_3(arr, 3);
    }

}