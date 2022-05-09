package com.leetcode.hot100question.math_test;

public class TestPow {

    public double myPow(double x, int n) {
        if (x == 1 || n == 0){
            return 1;
        }
        //避免int最小值转最大值的溢出问题
        long a = n;

        if (n < 0){
            a = -a;
            x = 1/x;
        }
        double res = 1.0;
        while ( a > 0){
            res *= (a&1)==1?x:1;
            x *= x;
            a >>= 1;
        }
        return res;
    }
}
