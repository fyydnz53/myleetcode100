package com.leetcode.hot100question.list;

import com.leetcode.hot100question.ListNode;

public class ResverList {
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return head;
        }
        //找一个临时节点做遍历使用
        ListNode tmpNode = head;
        //设置一个节点记录下一个节点
        ListNode tmpNode2;
        //设置一个节点记录上一个节点
        ListNode tmpNode3 = null;
        while(tmpNode.next!= null){
            tmpNode2 = tmpNode.next;
            //当前节点下一个节点等于上一个节点
            tmpNode.next = tmpNode3;
            //下一个节点移动为当前节点
            tmpNode3 = tmpNode;
            //当前节点后移
            tmpNode = tmpNode2;
        }
        //最后一个节点的上一个节点反转
        tmpNode.next = tmpNode3;
        return tmpNode;
    }
}
