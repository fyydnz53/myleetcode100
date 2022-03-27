package com.leetcode.hot100question.string;


public class Reserselef {

    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcdefg",2));
    }
    public static String reverseLeftWords(String s, int n) {
        int length = s.length();
        char[] bytes = new char[length];
        for (int i = 0; i < length; i++) {
            if (i < n) {
                System.out.println(s.charAt(i));
                bytes[i + length - n] = s.charAt(i);
            }else {
                System.out.println(s.charAt(i));
                bytes[i-n] = s.charAt(i);
            }
        }
        return new String(bytes);
    }
}
