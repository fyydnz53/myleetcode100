package com.leetcode.hot100question.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiang
 */
public class SubStr {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> chars = new HashMap<>(s.length() * 2);
        int start = 0, result = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (chars.containsKey(c) && chars.get(c) >= start) {
                result = Math.max(result,
                        i - start);
                start = chars.get(c) + 1;
            }
            chars.put(c,i);
        }
        result = Math.max(s.length()-start,result);
        if (chars.size() == s.length()){
            result = s.length();
        }

        return result;
    }
}
