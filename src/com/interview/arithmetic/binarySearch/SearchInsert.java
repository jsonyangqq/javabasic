package com.interview.arithmetic.binarySearch;

/**
 * @author jason.yang
 * @Description 搜索插入位置
 *
 * @Date 2021-01-10 21:54
 */
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0,right=n-1;
        //需要考虑三种情况，1.需要插入的位置在最左边，2.需要插入的位置在最右边，3.需要插入的位置在中间
        while (left<right) {
            int mid = left + ((right-left) >> 1);  //由于加法运算符的优先级要高
            if(target > nums[mid]) {   //区间范围在左边
                left = mid + 1;
            }else {                     //区间范围在右边
                right = mid - 1;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        int target = 1;
        SearchInsert searchInsert = new SearchInsert();
        System.out.println(searchInsert.searchInsert(nums, target));
    }

}