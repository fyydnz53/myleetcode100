package com.leetcode.hot100question.queue;

import java.util.Stack;

public class CCQueue {

    private Stack<Integer> in;

    private Stack<Integer> out;

    public CCQueue() {
        in = new Stack<>();
        out = new Stack<>();

    }

    public void appendTail(int value) {
        synchronized (this){
            in.push(value);
        }
    }

    public int deleteHead() {
        if (out.isEmpty()){
            if (in.isEmpty()){
                return -1;
            }
            synchronized (this){
                while (!in.isEmpty()){
                    out.push(in.pop());
                }
            }
        }
        return out.pop();
    }
}
