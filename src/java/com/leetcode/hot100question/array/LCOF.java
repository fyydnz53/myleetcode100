package com.leetcode.hot100question.array;

import com.leetcode.hot100question.ListNode;

import java.util.LinkedList;

public class LCOF {

    public int[] reversePrint(ListNode head) {
        int x = 0;
       ListNode tmpNode = new ListNode(0,head);
        for (;tmpNode.next != null;tmpNode=tmpNode.next){
            x++;
        }
        int[] ints = new int[x];
        for (int i=0;i<x;i++){
            ints[x-i-1] = head.x;
            head = head.next;
        }
        return ints;
    }
}
