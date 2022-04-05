package com.leetcode.hot100question.dynamic.programming;

public class MaxValue {
    public int maxValue(int[][] grid) {
        int n = grid[0].length;
        int m = grid.length;
        //遍历整个,获得每个路径走到节点可以获得的最大值;
        for (int i = 1; i < n; i++) {
            grid[0][i] += grid[0][i - 1];
        }

        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = grid[i][j] + Math.max(grid[i][j - 1],
                        grid[i - 1][j]);
            }
        }
        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int a = 1;
        System.out.println(++a);
        System.out.println(a);
    }
}
