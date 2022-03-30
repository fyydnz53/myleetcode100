package com.leetcode.hot100question.array;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FirstUniqChar {
    public char firstUniqChar(String s) {
        Map<Character,Integer> charSite = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charSite.containsKey(c)){
                charSite.put(c,-1);
                if (!queue.isEmpty() && c == queue.peek()){
                    queue.poll();
                   while (!queue.isEmpty() && charSite.get(queue.peek()) == -1){
                       queue.poll();
                   }
                }
            }else {
                charSite.put(c,i);
                queue.add(c);
            }
        }
        return queue.isEmpty()?' ':queue.poll();
    }
}
