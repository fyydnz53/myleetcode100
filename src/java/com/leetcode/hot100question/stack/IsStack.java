package com.leetcode.hot100question.stack;

import java.util.Stack;

/**
 * @author jiang
 * 给定输入输出顺序判断是否是一个栈的输入输出
 */
public class IsStack {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> tmpStack = new Stack<>();
        int i = 0;
        for (int i1 : pushed) {
            tmpStack.push(i1);
            while (!tmpStack.isEmpty() && tmpStack.peek()==popped[i]){
                tmpStack.pop();
                i++;
            }
        }
        return tmpStack.isEmpty();
    }
}
