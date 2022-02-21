package com.leetcode.hot100question;

import java.util.HashMap;
import java.util.Map;
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
public class SonString03 {
    public static void main(String[] args) {
        System.out.println(Solution.lengthOfLongestSubstring("asjrgapa"));
      System.out.println(Solution.lengthOfLongestSubstring("ohomm"));
        System.out.println(Solution.lengthOfLongestSubstring("aabaab!bb"));
/*        System.out.println(Solution.lengthOfLongestSubstring("mnksdfasfb"));
        System.out.println(Solution.lengthOfLongestSubstring("mnksdfasfboiuy"));
        System.out.println(Solution.lengthOfLongestSubstring("asdfghjkl"));
        int x=0;
        System.out.println(++x);*/
    }

    static class Solution {
        public static int lengthOfLongestSubstring(String s) {
            Map<Character,Integer> map = new HashMap<>();
            int num = 0;//重复字符字段长度
            int m = 0;//最长重复字段长度
//            int n = 0;//第一个循环前的字符串长度
            int y = 0;//最后一个循环字段的字符串长度
//            int k = 0;//记录前端循环次数
            int j = -1;//记录最大被替代的数
   //            int l =0;//中间传递长度
            for (int i = 0; i <s.length() ; i++) {
                if(map.containsKey(s.charAt(i))){
                   if(map.get(s.charAt(i))>j){
//                        num =i-map.get(s.charAt(i));
//                        l = map.get(s.charAt(i))-j>j?map.get(s.charAt(i))-j:l;
                        num = i-j-1;
                       /* if(s.charAt(j) == s.charAt(i)){
                            num = i-j-1;
                        }else num = i-j;*/
                    }//??
 //                   num=map.get(s.charAt(i))>j?i-map.get(s.charAt(i)):num;//重复字段间距长度
 //                   n = ++k == 1?i:n;//第一次出现重复时的字符串长度
//                    if(num>m) m=num;
                    m = num>m?num:m;//取最长重复字段
                    j = map.get(s.charAt(i))>j?map.get(s.charAt(i)):j;//取得最大的被重复数的角标
                }
                map.put(s.charAt(i),i);
            }
            y = s.length()-j-1;//最后不重复字段长度：

            return map.size()==s.length()?s.length():m>y?m:y;
        }
    }
}
