package com.leetcode.hot100question.list;

import com.leetcode.hot100question.ListNode;

import java.util.HashSet;
import java.util.Set;

public class MergeTwoList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l2.next,l1);
            return l2;
        }

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode tmp1 = headA;
        ListNode tmp2 = headB;
        while(tmp1 != null || tmp2 != null){
            if(tmp1 !=null && set.contains(tmp1)){
                return tmp1;
            }
            set.add(tmp1);
            if(tmp2 != null && set.contains(tmp2)){
                return tmp2;
            }
            set.add(tmp2);
            tmp1 = tmp1 != null?tmp1.next:tmp1;
            tmp2 = tmp2 != null?tmp2.next:tmp2;
        }
        return null;
    }
}
