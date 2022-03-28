package com.leetcode.hot100question.array;

public class FindTwoArray {
    public static void main(String[] args) {
        int[][] a = new int[][]{{-5}};
        System.out.println(findNumberIn2DArray(a,
                -5));
    }
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        //从右上角开始,保证每次比较只有一个答案最多比较m+n次数:
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = 0, n = matrix[0].length - 1;
        while (m < matrix.length && n >= 0){
            if (matrix[m][n] > target){
                n--;
                continue;
            }
            if (matrix[m][n] < target){
                m ++;
                continue;
            }
            return true;
        }
    return false;
    }
}
