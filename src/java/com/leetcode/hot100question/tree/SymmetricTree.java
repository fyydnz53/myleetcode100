package com.leetcode.hot100question.tree;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return equal(root.left,root.right);
    }
    public boolean equal(TreeNode left,TreeNode right){
        if (left == right){
            return true;
        }
        if (left == null || right == null || left.val != right.val){
            return false;
        }

        return equal(left.left,right.right) && equal(left.right,right.left);
    }

}
