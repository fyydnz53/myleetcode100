package com.leetcode.hot100question.list;

import com.leetcode.hot100question.ListNode;

import java.util.Arrays;

public class MergeKList {
    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if(length == 0){
            return null;
        }
        if(length == 1){
            return lists[0];
        }
        if(length == 2){
           return mergeTwoLists(lists[0],lists[1]);
        }else{
           return mergeTwoLists(mergeKLists(Arrays.copyOf(lists,length/2)),mergeKLists(Arrays.copyOfRange(lists,length/2,length)));
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
