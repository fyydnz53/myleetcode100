package com.leetcode.hot100question.array;

/**
 * @author jiang
 * 调整数组顺序使奇数位于偶数前面
 */
public class JSortDouble {

    public int[] exchange(int[] nums) {
        int i = 0,j = nums.length - 1;
        while (i<j){
            while ((nums[i] & 1) == 1 && i < j){
                i ++;
            }

            while (((nums[j] & 1) == 0 && i < j)){
                j --;
            }

            if (i < j){
                int i1 = nums[i] ^ nums[j];
                nums[i] = i1^nums[i];
                nums[j] = i1^nums[i];
            }
        }

        return nums;
    }
}
