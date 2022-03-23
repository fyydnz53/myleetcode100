package com.leetcode.hot100question.queue;

import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.Objects;

public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        System.out.println(minStack.min());
        System.out.println(minStack.top());
        minStack.push(-3);
        System.out.println(minStack.min());
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.min());
        System.out.println(minStack.top());
    }

    private Node<Integer> stack;

    private Node<Integer> max;

    private Node<Integer> min;

    /** initialize your data structure here. */
    public MinStack() {
    }

    public void push(int x) {
       stack = new Node<>(x,stack);
       if(max == null || max.elem <= x){
           max = new Node<>(x,max);
       }
       if (min == null || min.elem >= x){
           min = new Node<>(x,min);
       }
    }

    public void pop() {
        if(Objects.isNull(stack)){
            return;
        }
        if (stack.elem.equals(max.elem)){
            max = max.next;
        }
        if (stack.elem.equals(min.elem)){
            min = min.next;
        }
        stack = stack.next;
    }

    public int top() {
        return max.elem;
    }

    public int min() {
        return min.elem;
    }

    public static class Node<E>{
        E elem;
        Node<E> next;

        public Node(E elem, Node<E> next) {
            this.elem = elem;
            this.next = next;
        }

        public Node() {
        }
    }
}


