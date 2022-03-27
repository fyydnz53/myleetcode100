package com.leetcode.hot100question.array;

public class FindMiss {
    public int missingNumber(int[] nums) {
        int left = 0,right = nums.length,mid = 0;
        while (left<right){
            mid = (left+right)/2;
            if (nums[mid] == mid){
                left = Math.max(mid,left+1);
            }
            if (nums[mid] == mid+1){
                right = mid;
            }
        }
        return left;
    }
}
