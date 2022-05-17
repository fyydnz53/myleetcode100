package com.leetcode.hot100question.math_test;

/**
 * @author jiang
 */
public class Robot {

    int m,n,k;
    boolean[][] check;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        check = new boolean[m][n];
      return dfs(0,0,0,0);
    }

    public int dfs(int y,int x,int sy,int sx){
        if (y == m || x == n || k < sx + sy || check[y][x]) {
            return 0;
        }
        check[y][x] = true;
        return 1 + dfs(y + 1,x,(y + 1) % 10 == 0? sy - 8:sy+1,sx) + dfs(y,x + 1,sy ,(x + 1) % 10 == 0? sx - 8:sx+1);
    }

    public static int getSum(int value){
        int re = 0;
        while(value != 0){
            re += value % 10;
            value /= 10;
        }
        return re;
    }
}
