package com.leetcode.hot100question.string;

import java.util.*;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * @author jiang
 */
public class Permutation {

    private List<String> results = new LinkedList<>();
    private char[] chars;

    public String[] permutation(String s) {
        chars = s.toCharArray();
        dfs(0);
        return results.toArray(new String[results.size()]);
    }


    public void dfs(int x){
        if (x == chars.length -1){
            results.add(Arrays.toString(chars));
        }

        Set<Character> set = new HashSet<>();
        for (int i = x; i < chars.length; i++) {
            if (set.contains(chars[i])) {
                continue;
            }
            set.add(chars[i]);
            swap(i,x);
            dfs(x + 1);
            swap(i,x);
        }

    }


    public void swap(int a,int b){
        char tmp = chars[a];
        chars[a] = chars[b];
        chars[b] = tmp;
    }

}
