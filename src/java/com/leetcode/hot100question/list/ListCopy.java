package com.leetcode.hot100question.list;

import java.util.HashMap;

public class ListCopy {

    //hash法
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> n2 = new HashMap<>();
        Node tmpNode = head;
        for (; tmpNode != null; tmpNode = tmpNode.next) {
            n2.put(tmpNode,
                    new Node(tmpNode.val));
        }
        Node result = new Node(0);
        tmpNode = head;
        for (; tmpNode != null; tmpNode = tmpNode.next) {
            result.next = n2.get(tmpNode);
            result.next.next = n2.get(tmpNode.next);
            result.next.random = n2.get(tmpNode.random);
            result = result.next;
        }
        return n2.get(head);
    }

    //复制法
    public Node copyRandomList2(Node head) {
        if (head == null) {
            return head;
        }

        Node tmp = head;

        for (; tmp != null; tmp = tmp.next.next) {
            Node node = new Node(tmp.val);
            node.next = tmp.next;
            tmp.next = node;
        }

        //补上随机的
        Node cur = head;
        for (; cur != null; cur = cur.next.next) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
        }

        //切分,不能直接拿
        Node re = head.next;
        for (cur = head; cur != null; cur = cur.next) {
          tmp = cur.next;
          cur.next = tmp.next;
        }
        return re;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
