package com.interview.arithmetic.binarySearch;

/**
 * @author jason.yang
 * @Description 在排序数组中查找元素的第一个和最后一个位置
 * @Date 2021-01-12 17:21
 */
public class SearchFisAndLasSite {

    public int[] searchRange(int[] nums, int target) {
        int first = searchFirstPositioned(nums,target);
        if(first == -1) {
            return new int[]{-1,-1};
        }
        int last = searchLastPositioned(nums, target);
        return  new int[]{first,last};
    }

    public int searchLastPositioned(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n -1;
        int mid = (right + left) >>> 1;
        while(left < right) {
            if(target > nums[mid]) {
                left = mid + 1;
            }else if(target == nums[mid]) {
                right = mid;
            }else {
                right = mid -1;
            }
        }
        if(nums[left] == target) {
            return left;
        }
        return -1;
    }

    public int searchFirstPositioned(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n -1;
        int mid = (right + left) >>> 1;
        while(left < right) {
            if(target > nums[mid]) {
                left = mid + 1;
            }else if(target == nums[mid]) {
                right = mid;
            }else {
                right = mid -1;
            }
        }
        if(nums[left] == target) {
            return left;
        }
        return -1;
    }

}