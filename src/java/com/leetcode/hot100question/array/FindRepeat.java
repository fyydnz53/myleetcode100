package com.leetcode.hot100question.array;

import java.util.HashSet;

public class FindRepeat {

    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> ints = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (ints.contains(nums[i])){
                return nums[i];
            }
            ints.add(nums[i]);
        }
        return -1;
    }

}
