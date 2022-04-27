package com.leetcode.hot100question.array;

/**
 * @author jiang
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        quickSort(a,
                0,
                8);
        for (int i : a) {
            System.out.println(i);
        }
    }

    public static void quickSort(int[] source, int start, int end) {
        //找到起点作业;
        if (start > end) {
            return;
        }
        int m = source[start];
        int i = start, j = end;
        while (i < j) {
            while (m <= source[j] && i < j) {
                j--;
            }

            while (m >= source[i] && i < j) {
                i++;
            }

            if (i < j) {
                int tmp = source[i];
                source[i] = source[j];
                source[j] = tmp;
            }
        }

        source[start] = source[i];
        source[i] = m;

        quickSort(source,
                start,
                i - 1);
        quickSort(source,
                j + 1,
                end);

    }


}
