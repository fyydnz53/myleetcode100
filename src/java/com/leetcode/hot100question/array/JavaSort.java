package com.leetcode.hot100question.array;

import java.util.Arrays;

public class JavaSort {
    public static void main(String[] args) {
        int[] a = {3,1,1};
        System.out.println(minArray2(a));
    }
    public int minArray(int[] numbers) {

        Arrays.sort(numbers);
        return numbers[0];
    }

    public static int minArray2(int[] numbers) {
        if (numbers.length ==1 ){
            return numbers[0];
        }
            int n = 0,m = numbers.length-1,mid =0;
            while(n < m){
                mid = n + (m-n)/2;
                if(numbers[mid] > numbers[mid+1]){
                    return numbers[mid+1];
                }
                if(numbers[mid] < numbers[m]){
                    m = mid;
                }else
                if (numbers[mid] > numbers[m]){
                    n ++;
                }else {
                    m --;
                }
            }
        return numbers[n];
    }
}
