package com.leetcode.hot100question.dynamic.programming;

/**
 * @author jiang
 */
public class ClimbLift {

    /**
     * 假设第n级台阶；最后可以选择一步或者两步；= f(n-1) + f(n-2)
     *
     * @param n
     * @return
     */
    public int numWays(int n) {

        final int mod = 1000000007;

        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        //滚动赋值
        int first = 1, second = 1, next = 0;
        for (int i = 2; i <= n; i++) {
            next = (first + second)%mod;
            first = second;
            second = next;
        }
        return next;
    }

}
