package com.leetcode.hot100question.dynamic.programming;

public class MaxValue {
    public int maxValue(int[][] grid) {
        int i = 0;
        int j = 0;
        int result = grid[0][0];
        while (i < grid.length - 1 && j < grid[0].length - 1) {
            if(grid[i+1][j]>grid[i][j+1]){
                result +=grid[++i][j];
            }else {
                result += grid[i][++j];
            }
        }
        while (i < grid.length - 1){
            result +=grid[++i][j];
        }
        while (j < grid[0].length - 1){
            result += grid[i][++j];
        }
        return result;
    }

    public static void main(String[] args) {
        int a = 1;
        System.out.println(++a);
        System.out.println(a );
    }
}
