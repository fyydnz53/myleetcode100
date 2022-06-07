package com.leetcode.hot100question.array;

import java.util.*;

/**
 * 三数之和
 * @author jiang
 */
public class ThreeNum {

    public static void main(String[] args) {
        int[] ints = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = new ThreeNum().threeSum(ints);

    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        if(nums.length < 3){
            return Collections.emptyList();
        }
        List<List<Integer>> result = new LinkedList<>();
        for(int k = 0; k< nums.length-2;k++){
            if(nums[k] > 0){
                break;
            }
            if(k > 0 && nums[k] == nums[k-1]){
                continue;
            }
            int i = k + 1, j = nums.length - 1;
            while(i < j){
                int sum = nums[k] + nums[i] + nums[j];
                if(sum < 0){
                    while(i < j && nums[i] == nums[++i]);
                } else if (sum > 0) {
                    while(i < j && nums[j] == nums[--j]);
                } else {
                    result.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }
            }
        }

        return result;
    }

}
