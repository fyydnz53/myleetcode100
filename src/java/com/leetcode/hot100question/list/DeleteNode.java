package com.leetcode.hot100question.list;

import com.leetcode.hot100question.ListNode;

public class DeleteNode {

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null){
            return null;
        }
        if (head.val == val){
            return head.next;
        }
        ListNode tmp = head;
        while (tmp.next != null){
            if (tmp.next.val == val){
                tmp.next = tmp.next.next;
                return head;
            }
            tmp = tmp.next;
        }
        return head;

    }
}
