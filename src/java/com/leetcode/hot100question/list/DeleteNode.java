package com.leetcode.hot100question.list;

import com.leetcode.hot100question.ListNode;

public class DeleteNode {

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null){
            return null;
        }
        if (head.x == val){
            return head.next;
        }
        ListNode tmp = head;
        while (tmp.next != null){
            if (tmp.next.x == val){
                tmp.next = tmp.next.next;
                return head;
            }
            tmp = tmp.next;
        }
        return head;

    }
}
