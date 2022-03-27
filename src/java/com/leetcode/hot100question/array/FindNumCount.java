package com.leetcode.hot100question.array;

/**
 * @author jiang
 */
public class FindNumCount {
    public static void main(String[] args) {
        int search = search2(new int[]{1, 3, 5, 5, 6},
                5);
        System.out.println(search);
    }

    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1 && nums[0]
                != target) {
            return 0;
        }
        //使用二分法解决
        int i = (nums.length + 1) / 2;
        if (nums[i - 1] > target) {
            int[] ints = new int[i];
            System.arraycopy(nums,
                    0,
                    new int[i],
                    0,
                    i);
            return search(ints,
                    target);
        }
        if (nums[i - 1] < target) {
            int[] ints = new int[nums.length - i];
            System.arraycopy(nums,
                    i,
                    new int[nums.length - i],
                    0,
                    nums.length - i);
            return search(ints,
                    target);
        }
        int n = 0;
        if (nums[i - 1] == target) {
            n++;
            for (int j = i; j < nums.length && nums[j] == target; j++) {
                n++;
            }
            for (int j = i - 2; j > -1 && nums[j] == target; j--) {
                n++;
            }
        }
        return n;
    }

    //不递归的二分法，找到左边界;
    public static int search2(int[] nums, int target) {
        int left = 0, right = nums.length - 1,mid = 0;
        while (left < right && nums[left] != target){
            mid = (left+right)/2;
            if (nums[mid] >= target){
                right = mid;
            }
            if (nums[mid] < target){
                left = left+1>mid?left+1:mid;
            }
        }
        int result = 0;
        while (nums[left++]==target){
            result ++;
        }
        return result;

    }
}
