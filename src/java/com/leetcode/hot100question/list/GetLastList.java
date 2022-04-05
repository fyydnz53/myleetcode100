package com.leetcode.hot100question.list;

import com.leetcode.hot100question.ListNode;

public class GetLastList {

    public ListNode getKthFromEnd(ListNode head, int k) {
            ListNode tmp = head;
            int i = 0;
            while (tmp != null){
                i++;
                tmp = tmp.next;
            }
        ListNode[] listNodes = new ListNode[i];
            tmp = head;
            i = 0;
            while (tmp!=null){
                listNodes[i++] = tmp;
                tmp = tmp.next;
            }
            return listNodes[listNodes.length-k];
    }
}
