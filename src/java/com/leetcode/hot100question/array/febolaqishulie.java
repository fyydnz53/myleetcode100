package com.leetcode.hot100question.array;

public class febolaqishulie {

    public static void main(String[] args) {
        System.out.println(fib(100));
    }

    /**
     * 直接递归空间与时间复杂度都太高了;使用滚动数组法
     *
     * @param n
     * @return
     */
    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        final int MOD = 1000000007;
        int p = 0, q = 0, r = 1;
        for (int i = 2; i < n; i++) {
            p = q;
            q = r;
            r = (p + q) % MOD;
        }
        return r;
    }
}
