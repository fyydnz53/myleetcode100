package com.leetcode.hot100question.array;

import java.util.Arrays;

/**
 * @author jiang
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字
 */
public class MinKNum {

    public static void main(String[] args) {
        new MinKNum().testMin();
    }
    public void testMin() {
        int[] ints = {0, 0, 2, 3, 2, 1, 1, 2, 0, 4};
        for (int leastNumber : getLeastNumbers(ints,
                10)) {
            System.out.println(leastNumber);
        }
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length <= k){
            return arr;
        }
      return quick(arr,k,0,arr.length-1);
    }

    public int[] quick(int[] arr,int k,int m,int n){
        int i = m,j = n ;
        while(i < j){
            while (arr[j] >= arr[m] && i < j){
                j--;
            }

            while(arr[i] <= arr[m] && i < j ) {
                i++;
            }

            swap(arr,i,j);
        }
        //左边都是比m号小于等于的;换了没有影响；小于等于换到小于等于区间
        swap(arr,m,i);
        if (i < k) {
            return quick(arr,k,i+1,n);
        }
        if (i > k) {
            return quick(arr,k,m,i-1);
        }
        return Arrays.copyOf(arr,k);
    }

    public void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
