package com.leetcode.hot100question.array;

import java.util.Arrays;
import java.util.Collections;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数
 * @author jiang
 */
public class GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        return Arrays.stream(arr).sorted().limit(k).toArray();
    }
}
