package com.leetcode.hot100question.dynamic.programming;

/**
 * @author jiang
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, result = 0;
        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i]) {
                result = Math.max(result,
                        max > min ? max - min:0);
                min = prices[i];
                max = 0;
            } else if (max < prices[i]) {
                max = prices[i];
            }
        }
        return Math.max(result,
                max > min ? max - min:0);
    }
}
