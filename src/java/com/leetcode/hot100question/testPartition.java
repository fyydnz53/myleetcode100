package com.leetcode.hot100question;

public class testPartition {

    public ListNode partition(ListNode head, int x) {
        ListNode big = new ListNode();
        ListNode small = new ListNode();
        ListNode tmpS = small;
        ListNode tmpB = big;

        while (head != null) {
            if (head.x < x) {
                tmpS.next = head;
                tmpS = tmpS.next;
            }else{
                tmpB.next = head;
                tmpB = tmpB.next;
            }
            head = head.next;
        }
        tmpB.next = null;
         tmpS.next = big.next;
        return small.next;

    }
}
