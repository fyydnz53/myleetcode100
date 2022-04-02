package com.leetcode.hot100question.dynamic.programming;

/**
 * @author jiang
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int tmp = nums[0];
            for (int i = 1; i < nums.length; i++) {
                //如果当前参数为负数且前面的和tmp与result取最大值保存
                //如果为正直接考虑当前和为正数就直接加上，负数直接替换；
                if (nums[i] < 0) {
                    result = Math.max(result,
                            tmp);
                    if (nums[i] + tmp > 0) {
                        tmp += nums[i];
                    } else {
                        tmp = nums[i];
                    }
                } else {
                    if (tmp < 0) {
                        tmp = nums[i];
                    } else {
                        tmp += nums[i];
                    }
                }
            }

            return Math.max(result,tmp);
    }

}
