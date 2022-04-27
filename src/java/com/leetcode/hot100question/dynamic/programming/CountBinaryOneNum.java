package com.leetcode.hot100question.dynamic.programming;

import java.lang.reflect.Array;
import java.util.stream.IntStream;

/**
 * @author jiang
 */
public class CountBinaryOneNum {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-3));
        System.out.println(hammingWeight2(2));
    }

    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        return IntStream.range(0,
                32).map(i -> (n >>> i) & 1
        ).sum();
    }


    // you need to treat n as an unsigned value
    public static int hammingWeight2(int n) {
        int count = 0;
        while(n != 0){
            count += n&1;
            n >>>= 1;
        }
        return count;
    }


    // you need to treat n as an unsigned value
    public static int hammingWeight3(int n) {
        int count = 0;
        while(n != 0){
            count ++;
            n &= (n-1);
        }
        return count;
    }
}
